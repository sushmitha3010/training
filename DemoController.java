package com.postoffice.postofficemanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.postoffice.postofficemanagement.model.UserModel;

@Controller
public class DemoController {
	
	Logger logger = LoggerFactory.getLogger(DemoController.class);
	@RequestMapping("/sush")
	public String dash(Model model) {
		logger.info("Demo Controller");
	
		UserModel register=new UserModel();
		model.addAttribute("register",register);
		return "Demo.html";
	}
}
