package com.whitelist.taxpayers.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AppController {
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

}
