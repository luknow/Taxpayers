package com.whitelist.taxpayers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whitelist.taxpayers.model.Form;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class AppController {

	private final int BANK_ACCOUNT_LENGTH = 26;
	private final int NIP_LENGTH = 10;
	private final int REGON_LENGTH = 9;
	private final String BANK_ACCOUNT_SEARCH_METHOD = "KontoBankowe";
	private final String NIP_SEARCH_METHOD = "Nip";
	private final String REGON_SEARCH_METHOD = "Regon";

	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("form", new Form());
		return "index";
	}

	@PostMapping("/search")
	public String search(@ModelAttribute("form") @Valid Form form, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		String number = "";
		String searchMethod = "";
		int numberLength = 0;

		if (bindingResult.hasErrors()) {
			model.addAttribute("form", form);
			return "index";
		}

		number = form.getNumber().trim();
		searchMethod = form.getSearchMethod();

		numberLength = getNumberLength(searchMethod);

		if (numberLength == -1) {
			redirectAttributes.addFlashAttribute("danger", "Wybrano niewłaściwą metodę wyszukiwania!");
			return "redirect:/";
		}

		if (number.matches("^[0-9]{" + numberLength + "}$") == false) {
			redirectAttributes.addFlashAttribute("danger", "Podano błędny numer!");
			return "redirect:/";
		}
		return "index";
	}

	public int getNumberLength(String searchMethod) {

		int numberLength = 0;

		switch (searchMethod) {
		case BANK_ACCOUNT_SEARCH_METHOD:
			numberLength = BANK_ACCOUNT_LENGTH;
			break;
		case NIP_SEARCH_METHOD:
			numberLength = NIP_LENGTH;
			break;
		case REGON_SEARCH_METHOD:
			numberLength = REGON_LENGTH;
			break;
		default:
			numberLength = -1;
		}
		
		return numberLength;
	}
}
