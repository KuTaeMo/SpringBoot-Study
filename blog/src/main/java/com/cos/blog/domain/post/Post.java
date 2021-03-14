package com.cos.blog.domain.post;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import com.cos.blog.domain.user.RoleType;
import com.cos.blog.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false,length=100)
	private String title;
	
	@Lob // MySQL = longtext , Oracle - Clob
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	private Timestamp createDate;
}
