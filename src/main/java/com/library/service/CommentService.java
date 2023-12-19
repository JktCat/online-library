package com.library.service;

import java.util.List;

import com.library.entity.Comment;

public interface CommentService {

	Comment saveComment(Comment comment);
	
	List<Comment> getCommentsByBookId(Long bookId);
	
	void deleteComment(Long id);
	
}
