package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query(value = "SELECT * FROM comments WHERE book_id = :bookId", nativeQuery = true)
	List<Comment> getCommentsByBookId(@Param("bookId") Long bookId);
}
