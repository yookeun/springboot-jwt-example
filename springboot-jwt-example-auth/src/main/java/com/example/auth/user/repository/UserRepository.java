package com.example.auth.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.auth.user.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where user_name = :username")
	User findByUsername(@Param("username") String username);
}
