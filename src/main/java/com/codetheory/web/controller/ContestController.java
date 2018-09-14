package com.codetheory.web.controller;

import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.constant.OrganizationType;
import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.Contest;
import com.codetheory.web.model.Round;
import com.codetheory.web.viewModel.GroupChallenge;
import com.codetheory.web.viewModel.RowContest;
import com.codetheory.web.viewModel.UserContest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/contest")
public class ContestController {

	@Autowired
	private ContestDAO dao;

	@Autowired
	private ChallengeDAO chdao;

	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createContest(Model model, Principal principal) {
		String user = principal.getName();
		UserContest con = new UserContest();
		con.setUser(user);
		ArrayList<RowContest> cl = new ArrayList<RowContest>();
		List<Contest> cons = dao.getContestsByUser(user);
		for (Contest var : cons) {
			cl.add(new RowContest(var));
		}		
		con.setMyContests(cl);
		model.addAttribute("newContest", con);
		return "createContest";
	}

	@RequestMapping(value="{name}/rounds", method = RequestMethod.GET)
	public String Rounds(Model model,@PathVariable("name") String cname, Principal principal) {
		String user = principal.getName();
		if(!dao.validUserContest(user, cname)){
			return "NotFound";
		}
		List<ChallengeGroup> challengeGroups = chdao.getChallengeGroups(user);
		ArrayList<ChallengeGroup> mcqs = new ArrayList<ChallengeGroup>();
        ArrayList<ChallengeGroup> codes = new ArrayList<ChallengeGroup>();
		GroupChallenge gc = new GroupChallenge();
        for (ChallengeGroup var : challengeGroups) {
            if (var.getChallengeType() == ChallengeType.MCQ) {
                mcqs.add(var);
            }
            if (var.getChallengeType() == ChallengeType.Code) {
                codes.add(var);
            }
        }
        gc.setCodeGroups(codes);
        gc.setMcqGroups(mcqs);
		List<Round> rounds = dao.getRounds(cname);
		model.addAttribute("cname", cname);
		model.addAttribute("rounds", rounds);		
		model.addAttribute("groups", gc);
		return "round";
	}	

	@RequestMapping(value="/create", method=RequestMethod.POST)
    public String register(@ModelAttribute("contest") Contest con, Principal principal) {
		String user = principal.getName();
		dao.addContest(con, user);
        return "redirect:/contest/create";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newContest(Model model) {
		Contest contest = new Contest();
		model.addAttribute("contest", contest);		
		model.addAttribute("orgs", OrganizationType.values());
		model.addAttribute("update", false);
		model.addAttribute("action", "/contest/create");
		return "contestdetail";
	}

	@RequestMapping(value="/update/{name}", method = RequestMethod.GET)
	public String newContest(Model model, @PathVariable("name") String name) {
		Contest contest = dao.getContestById(name);
		
		if(contest == null)
			return "redirect:/contest/create";

		//System.out.println(contest.getStartDate().toLocaleString());
		model.addAttribute("contest", contest);		
		model.addAttribute("orgs", OrganizationType.values());
		model.addAttribute("update", true);
		model.addAttribute("action", "/contest/update/" + name);
		System.out.println(contest.getStartDate());
		return "contestdetail";
	}

	@RequestMapping(value="/update/{name}", method = RequestMethod.POST)
	public String updateContest(Model model, @ModelAttribute("contest") Contest con, @PathVariable("name") String name, Principal principal) {	
		//validate update time < starting time
		dao.updateContest(con);
		System.out.println(con.getContestname());
		return "redirect:/contest/manage/"+name;
	}

	@RequestMapping(value="/manage/{name}", method = RequestMethod.GET)
	public String manageContest(Model model, @PathVariable("name") String name, Principal principal) {
		String user = principal.getName();
		//contest must belong to the author
		if(!dao.validUserContest(user, name)){
			return "redirect:/contest/create";
		}
		model.addAttribute("contest", name);
		//model.addAttribute("owner", user);
		return "manageContest";
	}	

	@RequestMapping (value="/{contestName}")
	public String startContest (@PathVariable ("contestName") String contestName , Principal principal, Model model){
		
		Contest contest = dao.getContestByContestName (contestName);
		if (contest == null)
			return "/Error";

		//if contest is ended
		
		if (dao.isContestEnded(contestName)){
			model.addAttribute("contest", contest);
			return "contestEnd";
		}

		// if contest is not started

		else if( dao.isContestNotStarted (contestName)){

			model.addAttribute ("contestStartDate", contest.getStartDate().getTime());
			model.addAttribute ("contestEndDate", contest.getEndDate().getTime());


			model.addAttribute("contest", contest);
			return "contestLandingPage";
		}
		
		// if contest is started
		else if(dao.isContestStarted(contestName)){

			if (principal != null) {	//if user is logged in

				if (dao.isParticipated (principal.getName(), contestName)){
					return "redirect:/contest/{contestName}/round";
				}

				else {
					return "contestAlreadyStarted";
				}
			}

			else {
				return "contestAlreadyStarted";
			}
		}

		else {
			return "Error";
		}
		
		
	}


	@RequestMapping (method = RequestMethod.GET, value = "practice/quiz")
    public String quizRound (Model model) {

        model.addAttribute("contestname", "practice");
		model.addAttribute("round" , new Round ("quiz", ChallengeType.MCQ));
		model.addAttribute ("roundName", "Round");

		return "roundone";
    }

    @RequestMapping(value = "practice/codinground", method = RequestMethod.GET)
	public String codingRound(Model model) {
				
		model.addAttribute("contestname", "practice");
		model.addAttribute("round" , new Round ("Coding", ChallengeType.Code));
		return "codinground";
    }


    @RequestMapping (method = RequestMethod.GET, value = "{contestname}/round")
    public String round (@PathVariable("contestname") String contestName, 
                         Model model,
                        Principal principal){
                           


		List <Round> roundList = dao.getAllRounds (contestName);
		Round currentRound = null;
		Round nextRound = null;
		Date currentDate = new Date();
		boolean timelimit = dao.roundTimelimit(contestName);

		for (Round round : roundList) {

			if (currentDate.after (round.getStartTime()) && currentDate.before (round.getEndTime())) {
				currentRound = round;
			}

			else if (currentDate.before (round.getStartTime())) {
				nextRound = round;
				break;
			}
		}

		if (currentRound != null) {
		
	        String roundName = currentRound.getName();

	        //checking if user has already made a submission
			if (dao.isUserAlreadySubmitted (contestName, roundName, principal.getName() )){
				
				if (nextRound == null)
					return "contestEnd";
				else {
					model.addAttribute("nextRound", nextRound);
					model.addAttribute ("contestStartDate", nextRound.getStartTime().getTime());
					
					return "timer";
				}
			}

			//if user has not made any submission
			else {
				System.out.println ("here /Error");
				ChallengeType type = currentRound.getType();
		
				model.addAttribute("contestname" , contestName);
				model.addAttribute("roundName" , currentRound.getName());
				model.addAttribute("startDate" , currentRound.getStartTime().getTime());
				model.addAttribute("endDate" , currentRound.getEndTime().getTime());
				
				model.addAttribute ("timelimit", timelimit);

				if (type.getValue() == 1)
					return "roundone";
		
				else if (type.getValue() == 2)
					return "codinground";
				
				else
					return "/Error";
			}
		}

		else if (nextRound != null) {
			System.out.println ("here");
			model.addAttribute ("nextContest", nextRound);
			return "timer";
		}
		else {
			return "/Error";
		}

    }

	@RequestMapping (value="/all")
	public String allContest (Model model){
		
		List<Contest> contests = dao.getAllContest();
		List<Integer> participants = new ArrayList<>();

		for (Contest con: contests){
			participants.add (dao.getNumberOfParticipants (con.getContestname()));
		}


		model.addAttribute ("contestList", contests);
		model.addAttribute ("participants", participants);
		
		return "contests";
	}
}