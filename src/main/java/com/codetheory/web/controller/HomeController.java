package com.codetheory.web.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.codetheory.web.model.Card;
import com.codetheory.web.viewModel.Cards;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String Home(Model model) {
		return "home";
	}

	@RequestMapping(value="/cards/{no}", method=RequestMethod.GET)
	public ModelAndView getCards(@PathVariable int no){
		//get list of new competitons
		ArrayList<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(12, "CodeLab - 2017", "This document does not provide you with any legal rights to any intellectual property of the product"));
		cardList.add(new Card(13, "Hackathon - 2018", "This document does not provide you with any legal rights to any intellectual property of the product"));
   		Cards wrapper = new Cards();
		wrapper.setCards(cardList);
		ModelAndView model = new ModelAndView("cards");
		model.addObject("cardList", wrapper);
		//test loading
		try{Thread.sleep(5000);}catch(Exception ex){}

		return model;
	}
}