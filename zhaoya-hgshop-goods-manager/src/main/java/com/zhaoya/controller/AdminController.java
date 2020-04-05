package com.zhaoya.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhaoya.common.HgConstant;

@Controller
@RequestMapping("admin")
public class AdminController {

	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("login")
	public String login(HttpServletRequest request, String username, String password) {
		request.getSession().setAttribute(HgConstant.USER_KEY, username);

		return "redirect:/index";
	}
}