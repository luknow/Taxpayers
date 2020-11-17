package com.whitelist.taxpayers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whitelist.taxpayers.api.EntityListResponse;
import com.whitelist.taxpayers.model.Form;
import com.whitelist.taxpayers.service.ApiService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
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

	private ApiService apiService;

	public AppController(ApiService apiService) {
		this.apiService = apiService;
	}

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
		ResponseEntity<EntityListResponse> responseEntity = null;

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

		try {
			responseEntity = sendRequestToGovernmentalAPI(searchMethod, number);
			responseEntity.getBody().getResult().setDate(getCurrentDate());
			model.addAttribute("results", responseEntity.getBody().getResult());
		} catch (BadRequest e) {
			redirectAttributes.addFlashAttribute("danger", e.getLocalizedMessage().split("\"")[7]);
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

	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public ResponseEntity<EntityListResponse> sendRequestToGovernmentalAPI(String searchMethod, String number) {

		ResponseEntity<EntityListResponse> responseEntity = null;

		switch (searchMethod) {
		case BANK_ACCOUNT_SEARCH_METHOD:
			responseEntity = apiService.bankAccountdate(number, getCurrentDate());
			break;
		case NIP_SEARCH_METHOD:
			responseEntity = apiService.nipsdate(number, getCurrentDate());
			break;
		case REGON_SEARCH_METHOD:
			responseEntity = apiService.regonsdate(number, getCurrentDate());
			break;
		}
		return responseEntity;
	}
}
