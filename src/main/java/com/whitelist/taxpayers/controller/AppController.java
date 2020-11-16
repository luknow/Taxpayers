package com.whitelist.taxpayers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.whitelist.taxpayers.model.Form;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class AppController {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@PostMapping("/search")
	public String search(@ModelAttribute("form") @Valid Form form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("form", form);
			return "index";
		}
		return "index";
	}
}
