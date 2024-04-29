package com.bits.bookapplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bits.bookapplication.entities.UserEntity;

public interface UserDAO extends JpaRepository<UserEntity,Integer>  {

	@Transactional
	Optional<UserEntity> findByUsername(String username);
	
	@Query(value="SELECT COUNT (*) FROM USERS e where e.username = :username")
	Integer checkIfUserExist(@Param(value="username") String username);

	@Transactional
	@Modifying(flushAutomatically=true,clearAutomatically=true)
	@Query(value="DELETE FROM USERS e where e.username = :username")
	int deleteUserByUsername(@Param (value="username") String username);
}
