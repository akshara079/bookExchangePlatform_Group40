package com.bits.bookapplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bits.bookapplication.entities.BookEntity;

public interface BookDAO extends JpaRepository<BookEntity,Integer> {
	
	@Transactional
	Optional<BookEntity> findByTitle(String title);
	
	Optional<BookEntity> findById(Integer id);
	
	@Query(value="SELECT COUNT (*) FROM BOOKS e where e.title = :title")
	Integer checkIfBookExist(@Param(value="title") String title);
	
	@Transactional
	@Modifying(flushAutomatically=true,clearAutomatically=true)
	@Query(value="DELETE FROM BOOKS e where e.title = :title")
	int deleteUserByTitle(@Param (value="title") String title);


}
