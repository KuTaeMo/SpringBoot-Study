package com.cos.blog.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;

@Controller
public class UserController {
	
	// 403 뜸 : 인증 안 됨.
	@GetMapping("/user")
	public @ResponseBody String findAll(@AuthenticationPrincipal PrincipalDetails principalDetails) { // @Controller + @ResponseBody = @RestController
//		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//		PrincipalDetails principalDetails= (PrincipalDetails)authentication.getPrincipal();
//		System.out.println(principalDetails.getUser());
		System.out.println(principalDetails.getUsername());
		return "User";
	}

}