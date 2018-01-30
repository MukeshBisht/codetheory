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
@RequestMapping("/RoundOne")
public class RoundOneController {

	@RequestMapping(method = RequestMethod.GET)
	public String RoundOne(Model model) {
		return "roundone";
	}
	
}