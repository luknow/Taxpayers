package com.whitelist.taxpayers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.whitelist.taxpayers.controller.AppController;

public class AppControllerUnitTest {
	
	private AppController appController = new AppController(null);  
		
	@Test
	public void shouldReturnBankAccountNumberLengthSearchByBankAccount() throws Exception {
		assertTrue(appController.getNumberLength("KontoBankowe") == 26);
	}
	
	@Test
	public void shouldReturnRegonNumberLengthSearchByRegon() throws Exception {
		assertTrue(appController.getNumberLength("Regon") == 9);
	}
	
	@Test
	public void shouldReturnNipNumberLengthSearchByNip() throws Exception {
		assertTrue(appController.getNumberLength("Nip") == 10);
	}
	
	@Test
	public void shouldReturnDateInFormatYYYMMdd() throws Exception {
		assertTrue(appController.getCurrentDate().matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$"));
	}
}
