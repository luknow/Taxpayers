package com.whitelist.taxpayers.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.whitelist.taxpayers.api.EntityCheckResponse;
import com.whitelist.taxpayers.api.EntityListResponse;
import com.whitelist.taxpayers.api.EntityResponse;

import io.swagger.annotations.ApiParam;

@Service
public class ApiService {

	@Value("${govermentalAPIURL}")
	private String URL;

	@org.springframework.beans.factory.annotation.Autowired
	public ApiService() {

	}

	public ResponseEntity<EntityListResponse> bankAccountdate(
			@Size(min = 26, max = 26) @ApiParam(value = "Numer rachunku bankowego", required = true) @PathVariable("bank-account") String bankAccount,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityListResponse> entity = restTemplate.getForEntity(
				URL + "/api/search/bank-account/" + bankAccount + "?date=" + date, EntityListResponse.class);
		return entity;
	}

	public ResponseEntity<EntityListResponse> bankAccountsdate(
			@Size(min = 26) @ApiParam(value = "Lista maksymalnie 30 numerow rachunkow bankowych rozdzielonych przecinkami ", required = true) @PathVariable("bank-accounts") String bankAccounts,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityListResponse> entity = restTemplate.getForEntity(
				URL + "/api/search/bank-accounts/" + bankAccounts + "?date=" + date, EntityListResponse.class);
		return entity;
	}

	public ResponseEntity<EntityCheckResponse> checkNip(
			@Size(min = 10, max = 10) @ApiParam(value = "Nip", required = true) @PathVariable("nip") String nip,
			@Size(min = 26, max = 26) @ApiParam(value = "Numer rachunku bankowego", required = true) @PathVariable("bank-account") String bankAccount,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityCheckResponse> entity = restTemplate.getForEntity(
				URL + "/api/check/nip/" + nip + "/bank-account/" + bankAccount, EntityCheckResponse.class);
		return entity;
	}

	public ResponseEntity<EntityCheckResponse> checkRegon(
			@Pattern(regexp = "^\\d{9}$|^\\d{14}$") @ApiParam(value = "Regon", required = true) @PathVariable("regon") String regon,
			@Size(min = 26, max = 26) @ApiParam(value = "Numer rachunku bankowego", required = true) @PathVariable("bank-account") String bankAccount,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityCheckResponse> entity = restTemplate.getForEntity(
				URL + "/api/check/regon/" + regon + "/bank-account/" + bankAccount, EntityCheckResponse.class);
		return entity;
	}

	public ResponseEntity<EntityResponse> nipdate(
			@Size(min = 10, max = 10) @ApiParam(value = "Nip", required = true) @PathVariable("nip") String nip,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityResponse> entity = restTemplate
				.getForEntity(URL + "/api/search/nip/" + nip + "?date=" + date, EntityResponse.class);
		return entity;
	}

	public ResponseEntity<EntityListResponse> nipsdate(
			@Size(min = 10) @ApiParam(value = "Lista maksymalnie 30 numerow NIP rozdzielonych przecinkami", required = true) @PathVariable("nips") String nips,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityListResponse> entity = restTemplate
				.getForEntity(URL + "/api/search/nips/" + nips + "?date=" + date, EntityListResponse.class);
		return entity;
	}

	public ResponseEntity<EntityResponse> regondate(
			@Pattern(regexp = "^\\d{9}$|^\\d{14}$") @ApiParam(value = "Regon", required = true) @PathVariable("regon") String regon,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityResponse> entity = restTemplate
				.getForEntity(URL + "/api/search/regon/" + regon + "?date=" + date, EntityResponse.class);
		return entity;
	}

	public ResponseEntity<EntityListResponse> regonsdate(
			@ApiParam(value = "Regon", required = true) @PathVariable("regons") String regons,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<EntityListResponse> entity = restTemplate
				.getForEntity(URL + "/api/search/regons/" + regons + "?date=" + date, EntityListResponse.class);
		return entity;
	}
}
