package com.whitelist.taxpayers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.whitelist.taxpayers.api.Entity;
import com.whitelist.taxpayers.api.EntityList;
import com.whitelist.taxpayers.api.EntityListResponse;
import com.whitelist.taxpayers.controller.AppController;
import com.whitelist.taxpayers.service.ApiService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class AppControllerIntegrationTest {

	private MockMvc mockMvc;

	@InjectMocks
	private AppController appController;

	@Mock
	ApiService apiService;

	@BeforeAll
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(appController).build();
	}

	@Test
	public void shouldReturnHomePageCorrectly() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void shouldReturnMethodNotAllowedPostHomePage() throws Exception {
		this.mockMvc.perform(post("/")).andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void shouldReturnErrorFieldNumberEmpty() throws Exception {
		this.mockMvc.perform(post("/search").param("number", "").param("searchMethod", "Nip"))
				.andExpect(redirectedUrl("/"))
				.andExpect(MockMvcResultMatchers.flash().attribute("danger", "Podano błędny numer!"));
	}

	@Test
	public void shouldReturnErrorSearchMethodNotAllowed() throws Exception {
		this.mockMvc.perform(post("/search").param("number", "7010316434").param("searchMethod", "Some"))
				.andExpect(redirectedUrl("/")).andExpect(
						MockMvcResultMatchers.flash().attribute("danger", "Wybrano niewłaściwą metodę wyszukiwania!"));
	}

	@Test
	public void shouldReturnErrorNipNumberIsNotValidTooManyDigits() throws Exception {
		this.mockMvc.perform(post("/search").param("number", "60606164457").param("searchMethod", "Nip"))
				.andExpect(redirectedUrl("/"))
				.andExpect(MockMvcResultMatchers.flash().attribute("danger", "Podano błędny numer!"));
	}

	@Test
	public void shouldReturnRegonResultCorrectly() throws Exception {

		EntityListResponse entityListResponse = new EntityListResponse();
		List<Entity> subjects = new ArrayList();
		Entity entity = new Entity();
		EntityList entityList = new EntityList();

		entity.setName("Company name as mock");
		entity.setNip("0000000000");
		entity.setRegon("000000000");
		entity.setWorkingAddress("Company address as mock");

		subjects.add(entity);

		entityList.setSubjects(subjects);
		entityList.setDate("2020-11-11");
		entityList.setRequestId("iia2a-89enf28");

		entityListResponse.setResult(entityList);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		dateFormat.format(date);

		when(apiService.regonsdate("123456789", dateFormat.format(date)))
				.thenReturn(new ResponseEntity<EntityListResponse>(entityListResponse, HttpStatus.OK));

		this.mockMvc.perform(post("/search").param("number", "123456789").param("searchMethod", "Regon"))
				.andExpect(status().isOk()).andExpect(model().attribute("results", entityListResponse.getResult()))
				.andExpect(view().name("index"));
	}

}