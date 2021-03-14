package com.cos.blog.web;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.service.PostService;
import com.cos.blog.web.post.dto.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PostController {
	
	private final PostService postService;
	
//	@GetMapping("/")
//	public String index() {
//		
//		return "index";
//	}
	
	@GetMapping("/")
	public String findAll(Model model, @PageableDefault(sort="id",direction=Sort.Direction.DESC,size=5)Pageable pageable,@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println("누구로 로그인됐을까");
		System.out.println(principalDetails.getAttributes());
		System.out.println(principalDetails.getUser().getUsername());
		
		Page<Post> posts=postService.전체찾기(pageable);

		// request 대신에 model에 넣어서 페이지까지 가져감
		model.addAttribute("posts",posts);
		return "post/list";
	}
	
	@GetMapping("/post/saveForm")
	public String saveForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public String save(PostSaveReqDto postSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Post post = postSaveReqDto.toEntity();
		post.setUser(principalDetails.getUser());
		
		//영속화된 엔티티
		Post postEntity = postService.글쓰기(post);
		
		if(postEntity == null) {
			return "post/saveForm";
		}else {
			return "redirect:/";
		}
	}
}