package com.cos.myjpa.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.User.User;
import com.cos.myjpa.domain.User.UserRepository;
import com.cos.myjpa.web.dto.CommonRespDto;
import com.cos.myjpa.web.user.dto.UserJoinReqDto;
import com.cos.myjpa.web.user.dto.UserLoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;
	
	@PostMapping("/join") //auth(인증)
	public CommonRespDto<?> join(@RequestBody UserJoinReqDto userjoinReqDto){
		User userEntity=userRepository.save(userjoinReqDto.toEntity());
		return new CommonRespDto<>(1,"성공",userEntity);
	}
	
	@PostMapping("/login")
	public CommonRespDto<?> login(@RequestBody UserLoginReqDto userLoginReqDto){
		User userEntity=userRepository.findByUsernameAndPassword(userLoginReqDto.getUsername(), userLoginReqDto.getPassword());  // 없는 함수 만들기
		if(userEntity==null) {
			return new CommonRespDto<>(-1,"로그인 실패",null);
		}else {
			userEntity.setPassword(null); // 패스워드를 보여주면 안됨!
			session.setAttribute("principal", userEntity);
			return new CommonRespDto<>(1,"로그인 성공",userEntity);
		}
	}
	
	@GetMapping("/test/user/{id}") // 유저정보
	public CommonRespDto<?> userInfo(@PathVariable Long id){
		
		User principal=(User)session.getAttribute("principal");
		
		if(principal==null) {
			return new CommonRespDto<>(-1,"실패",null);
		}else {
			User userEntity=userRepository.findById(id).get();
			return new CommonRespDto<>(1,"성공",userEntity);
		}
	}
}
