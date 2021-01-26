package com.projectprop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	@RequestMapping("admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("user")
	public String userPage() {
		return "user";
	}

	@RequestMapping("vendor")
	public String vendorPage() {
		return "vendor";
	}

}