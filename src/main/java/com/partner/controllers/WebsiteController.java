package com.partner.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.partner.dataObjects.Admin;
import com.partner.dataObjects.PriceLumber;
import com.partner.service.AdminService;
import com.partner.service.PriceServiceControl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WebsiteController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	PriceServiceControl priceServiceControl;
	
	private Admin authAdmin;

	@GetMapping(value = "/")
	public String helloGet() {
		return "index";
	}
	
	@PostMapping(value = "/auth")
	public ResponseEntity<String> passAuth(@RequestParam("login") String login,
			@RequestParam("password") String password, RedirectAttributes redirectAttributes) {
		Optional<Admin> admin = adminService.authAdmin(login, password);
		if (admin.isPresent()) {
			authAdmin = admin.get();
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping(value = "/goMain")
	public String goToMain(RedirectAttributes redirectAttributes) {
		return "redirect:/main";
	}
	
	@GetMapping(value = "/main")
	public String goToMainPage(Model model) {
		try {
			String nameEmployee = authAdmin.getName();
			model.addAttribute("user_name", nameEmployee);
//			
//			List<PriceLumber> prices = new ArrayList<>();
//			prices = priceServiceControl.geAllPrice();
			
			
			return "main";
		} catch (Exception e) {
			return "index";
		}
		
	}

}
