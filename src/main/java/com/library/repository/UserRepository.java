package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
	User findByUsername(@Param("username") String username);

	@Query(value = "SELECT COUNT(*) > 0 FROM users WHERE username = :username AND password = :password", nativeQuery = true)
	boolean existsByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
