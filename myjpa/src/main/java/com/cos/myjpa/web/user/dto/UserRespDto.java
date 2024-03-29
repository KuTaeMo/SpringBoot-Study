package com.cos.myjpa.web.user.dto;

import java.time.LocalDateTime;

import com.cos.myjpa.domain.User.User;

import lombok.Data;

@Data
public class UserRespDto {
	private Long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime createData;
	
	public UserRespDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.createData = user.getCreateDate();
	}
}