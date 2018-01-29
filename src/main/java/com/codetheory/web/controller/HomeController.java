package com.codetheory.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.codetheory.web.model.Card;
import com.codetheory.web.viewModel.Cards;

import org.springframework.web.servlet.ModelAndView;

import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.Contest;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	ContestDAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public String Home(Model model) {
		return "home";
	}

	@RequestMapping(value="/cards/{no}", method=RequestMethod.GET)
	public ModelAndView getCards(@PathVariable int no){
		//get list of new competitons
		int id=0;
		ArrayList<Card> cardList = new ArrayList<Card>();
		List<Contest> contestList = dao.getAllContest();
		for (Contest con : contestList){
			Card card = new Card(id++ ,con.getContestname(), "This document does not provide you any legal rights to change it");
			card.setorganiser(con.getOrgName());
			card.setstartDate(con.getStartDate());
			cardList.add(card);
		}
	
   		Cards wrapper = new Cards();
		wrapper.setCards(cardList);
		ModelAndView model = new ModelAndView("cards");
		model.addObject("cardList", wrapper);
		//test loading
		try{Thread.sleep(500);}catch(Exception ex){}

		return model;
	}
}