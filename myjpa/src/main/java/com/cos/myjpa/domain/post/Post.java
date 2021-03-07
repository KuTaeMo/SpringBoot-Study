package com.cos.myjpa.domain.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.myjpa.domain.User.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Table, auto_increment, Sequence
	private Long id;
	@Column(length=60,nullable=false)
	private String title;
	@Lob // 대용량 데이터
	private String content;
	
	// 누가 적었는지?
	// 가져올 수가 N개라면 기본전략이 EAGER
	// 순방향 매핑
	@ManyToOne(fetch = FetchType.EAGER)//연관관계 맺는 법 FK의 주인인 곳에서 적어야됨.
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp
	private LocalDateTime createDate;
}
