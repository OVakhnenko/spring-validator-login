package com.vakhnenko.validator.login.controller;

import java.util.Map;

import javax.validation.Valid;

import com.vakhnenko.validator.login.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("userForm") User userForm,
			BindingResult result, Map<String, Object> model) {

		if (result.hasErrors()) {
			return "LoginForm";
		}
		return "LoginSuccess";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin1(Map<String, Object> model) {
		return viewLogin(model);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewLogin2(Map<String, Object> model) {
		return viewLogin(model);
	}

	private String viewLogin(Map<String, Object> model) {
		User user = new User();
		model.put("userForm", user);
		return "LoginForm";
	}
}