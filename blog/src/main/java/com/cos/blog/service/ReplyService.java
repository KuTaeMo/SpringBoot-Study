package com.cos.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.domain.reply.Reply;
import com.cos.blog.domain.reply.ReplyRepository;
import com.cos.blog.web.reply.dto.ReplySaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyService {

	private final ReplyRepository replyRepository;
	
	@Transactional
	public int 삭제하기(int id,int userId) {
		// 컨트롤러에서 막아도 주소로 때릴 수 있으니깐 서비스에서 막기
		Reply replyEntity=replyRepository.findById(id).get();
		if(replyEntity.getUser().getId()==userId) {
			replyRepository.deleteById(id);
			return 1;
		}else {
			return -1;
		}
	}
	
	public Reply 댓글쓰기(Reply reply) {
		return replyRepository.save(reply);
	}
}
