package com.cos.myjpa.web.post;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.myjpa.domain.User.User;
import com.cos.myjpa.domain.post.Post;
import com.cos.myjpa.domain.post.PostRepository;
import com.cos.myjpa.service.PostService;
import com.cos.myjpa.web.dto.CommonRespDto;
import com.cos.myjpa.web.post.dto.PostSaveReqDto;
import com.cos.myjpa.web.post.dto.PostUpdateReqDto;

import lombok.RequiredArgsConstructor;

/*
 * ORM = Object Relation Mapping (자바 오브젝트 먼저 만들고 DB에 테이블을 자동 생성, 자바 오브젝트로 연관관계를 맺을 수 있음)
 * JPA = Java오브젝트를 영구적으로 저장하기 위한 인터페이스 (함수)
*/

@RequiredArgsConstructor
@RestController
public class PostController {
	private final PostRepository postRepository;
	private final HttpSession session;
	private final EntityManager em;
	private final PostService postService;

	// 인증만 필요
	@PostMapping("/post")
	public CommonRespDto<?> save(@RequestBody PostSaveReqDto postSaveDto) { //title, content 
		//원래는 세션값을 넣어야함
		//User user = new User(1L, "ssar", "1234","ssar@nate.com",LocalDateTime.now());
		
		//세션값 받기
		User principal = (User)session.getAttribute("principal");
		if(principal == null) { //로그인이 안되었다는 뜻
			return new CommonRespDto<>(-1,"실패",null);
		}
		
		return new CommonRespDto<>(1,"성공",postService.한건저장(postSaveDto, principal));
	}
	
	// 인증만 필요
	@GetMapping("/post/{id}")
	public CommonRespDto<?> findByID(@PathVariable Long id){
		return new CommonRespDto<>(1, "성공", postService.한건찾기(id));
	}
	
	// 인증만 필요
	@GetMapping("/post")
	public CommonRespDto<?> findAll(){
		return new CommonRespDto<>(1,"성공",postService.모두찾기());
	}
	
	// 인증(Authentication) + 권한(Authorization)(쓴 사람만 수정 가능)
	@PutMapping("/post/{id}")
	public CommonRespDto<?> update(@PathVariable Long id, @RequestBody PostUpdateReqDto postUpdateReqDto){
//		Post p = new Post();
//		em.persist(p);
//		em.createNativeQuery("select * from post ");
		return new CommonRespDto<>(1,"성공", postService.한건수정(postUpdateReqDto, id));
	}
	
	// 인증(Authentication) + 권한(Authorization)(쓴 사람만 삭제 가능)
	@DeleteMapping("/post/{id}")
	public CommonRespDto<?> deleteById(@PathVariable Long id){
		postService.한건삭제(id);
	
		return new CommonRespDto<>(1, "성공", null);
	}

}