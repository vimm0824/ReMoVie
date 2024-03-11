package com.ReMoVie.infra.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserUiController {

	/**
	 * 로그인 ui
	 */
	@GetMapping("/log_in")
	public String logIn() {
		return "user/logIn";
	}

	/**
	 * 회원가입 ui
	 */
	@GetMapping("/sign_up")
	public String signUp() {
		return "user/signUp";
	}
	
	/**
	 * 비밀번호 찾기 ui
	 */
	@GetMapping("/find_password")
	public String findPassword() {
		return "user/findPassword";
	}
}
