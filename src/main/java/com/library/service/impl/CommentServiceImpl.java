package com.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entity.Comment;
import com.library.repository.CommentRepository;
import com.library.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentRepository commentRepo;

	public CommentServiceImpl(CommentRepository commentRepo) {
		super();
		this.commentRepo = commentRepo;
	}

	@Override
	public Comment saveComment(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public List<Comment> getCommentsByBookId(Long bookId) {
		return commentRepo.getCommentsByBookId(bookId);
	}

	@Override
	public void deleteComment(Long id) {
		commentRepo.deleteById(id);
	}

	
	
	
}
