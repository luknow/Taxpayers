package com.whitelist.taxpayers.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "api", description = "the api API")
public interface ApiInterface {
	
	@ApiOperation(value = "", nickname = "bankAccountdate", notes = "Wyszukiwanie podmiotow po numerze konta", response = EntityListResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista podmiotow, które spełnily warunki wyszukiwania", response = EntityListResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/search/bank-account/{bank-account}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityListResponse> bankAccountdate(
			@Size(min = 26, max = 26) @ApiParam(value = "Numer rachunku bankowego", required = true) @PathVariable("bank-account") String bankAccount,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);

	@ApiOperation(value = "", nickname = "bankAccountsdate", notes = "Wyszukiwanie podmiotow po numerach kont", response = EntityListResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista podmiotow, które spelnily warunki wyszukiwania", response = EntityListResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/search/bank-accounts/{bank-accounts}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityListResponse> bankAccountsdate(
			@Size(min = 26) @ApiParam(value = "Lista maksymalnie 30 numerow rachunkow bankowych rozdzielonych przecinkami ", required = true) @PathVariable("bank-accounts") String bankAccounts,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);

	@ApiOperation(value = "", nickname = "checkNip", notes = "Sprawdzenie pojedynczego podmiotu po nip i numerze konta", response = EntityCheckResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Informacja, że dany rachunek jest przypisany do podmiotu", response = EntityCheckResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/check/nip/{nip}/bank-account/{bank-account}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityCheckResponse> checkNip(
			@Size(min = 10, max = 10) @ApiParam(value = "Nip", required = true) @PathVariable("nip") String nip,
			@Size(min = 26, max = 26) @ApiParam(value = "Numer rachunku bankowego", required = true) @PathVariable("bank-account") String bankAccount,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);

	@ApiOperation(value = "", nickname = "checkRegon", notes = "Sprawdzenie pojedynczego podmiotu po regon i numerze konta", response = EntityCheckResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Informacja, że dany rachunek jest przypisany do podmiotu", response = EntityCheckResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/check/regon/{regon}/bank-account/{bank-account}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityCheckResponse> checkRegon(
			@Pattern(regexp = "^\\d{9}$|^\\d{14}$") @ApiParam(value = "Regon", required = true) @PathVariable("regon") String regon,
			@Size(min = 26, max = 26) @ApiParam(value = "Numer rachunku bankowego", required = true) @PathVariable("bank-account") String bankAccount,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);

	@ApiOperation(value = "", nickname = "nipdate", notes = "Wyszukiwanie pojedynczego podmiotu po nip", response = EntityResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pojedynczy podmiot, który spełnił warunki wyszukiwania", response = EntityResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/search/nip/{nip}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityResponse> nipdate(
			@Size(min = 10, max = 10) @ApiParam(value = "Nip", required = true) @PathVariable("nip") String nip,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);

	@ApiOperation(value = "", nickname = "nipsdate", notes = "Wyszukiwanie podmiotow po numerach nip", response = EntityListResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista podmiotów, które spełniły warunki wyszukiwania", response = EntityListResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/search/nips/{nips}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityListResponse> nipsdate(
			@Size(min = 10) @ApiParam(value = "Lista maksymalnie 30 numerow NIP rozdzielonych przecinkami", required = true) @PathVariable("nips") String nips,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);

	@ApiOperation(value = "", nickname = "regondate", notes = "Wyszukiwanie pojedynczego podmiotu po regon", response = EntityResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pojedynczy podmiot, który spełnił warunki wyszukiwania", response = EntityResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/search/regon/{regon}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityResponse> regondate(
			@Pattern(regexp = "^\\d{9}$|^\\d{14}$") @ApiParam(value = "Regon", required = true) @PathVariable("regon") String regon,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);

	@ApiOperation(value = "", nickname = "regonsdate", notes = "Wyszukiwanie podmiotow po numerach regon", response = EntityListResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista podmiotów, które spełniły warunki wyszukiwania", response = EntityListResponse.class),
			@ApiResponse(code = 400, message = "niepoprawny parametr na wejściu") })
	@RequestMapping(value = "/api/search/regons/{regons}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<EntityListResponse> regonsdate(
			@ApiParam(value = "Regon", required = true) @PathVariable("regons") String regons,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "date", required = true) String date);
}