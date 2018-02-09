package com.codetheory.web.controller;

import com.codetheory.web.constant.OrganizationType;
import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.Contest;
import com.codetheory.web.model.Round;
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

@Controller
@RequestMapping("/contest")
public class ContestController {

	@Autowired
	private ContestDAO dao;

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
			return "redirect:/contest/create";
		}
		List<Round> rounds = dao.getRounds(cname);
		model.addAttribute("cname", cname);
		model.addAttribute("rounds", rounds);
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

		model.addAttribute("contest", contest);		
		model.addAttribute("orgs", OrganizationType.values());
		model.addAttribute("update", true);
		model.addAttribute("action", "/contest/update/" + name);
		return "contestdetail";
	}

	@RequestMapping(value="/update/{name}", method = RequestMethod.POST)
	public String updateContest(Model model, @ModelAttribute("contest") Contest con, @PathVariable("name") String name, Principal principal) {
		Contest contest = new Contest();
		model.addAttribute("contest", contest);		
		model.addAttribute("orgs", OrganizationType.values());
		model.addAttribute("update", true);
		return "contestdetail";
	}

	@RequestMapping(value="/manage/{name}", method = RequestMethod.GET)
	public String manageContest(Model model, @PathVariable("name") String name, Principal principal) {
		String user = principal.getName();
		//contest must belong to the auther
		if(!dao.validUserContest(user, name)){
			return "redirect:/contest/create";
		}
		model.addAttribute("contest", name);
		//model.addAttribute("owner", user);
		return "manageContest";
	}	

	@RequestMapping (value="/{contestName}")
	public ModelAndView startContest (@PathVariable ("contestName") String contestName){
		
		Contest contest = dao.getContestByContestName(contestName);
		ModelAndView modelandview = new ModelAndView("contestBegin");
		modelandview.addObject(contest);
		return modelandview;
	}
}