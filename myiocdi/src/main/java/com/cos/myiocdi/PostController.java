package com.cos.myiocdi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Component(용도 없음), Configuration(설정파일), Service(서비스), Repository(레파지토리), Bean

// RestController, Controller => IoC(싱글톤) 등록 new PostController(주입);
@RestController
public class PostController {

	
	private final Robot robot; //DI
	
	public PostController(Robot robot) {
		super();
		this.robot = robot;
	}

	@GetMapping("/")
	public String home() {
		return "home "+robot.getName();
	}
}
