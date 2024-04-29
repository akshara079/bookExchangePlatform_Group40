package com.bits.bookapplication.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity(name="BOOKS")
@Table(name="BOOKS")
@IdClass(BookPK.class)
public class BookEntity implements Serializable {
	
	@Id
	@Column(name="ID",nullable=false,unique=true)
	private int id;
	
	@Id
	@Column(name="USER_ID",nullable=false,unique=true)
	private int user_id;
	
	@Column(name="TITLE",nullable=false)
	private String title;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="GENRE")
	private String genre;
	
	@Column(name="BOOK_CONDITION")
	private String book_condition;
	
	@Column(name="AVAILABILITY_STATUS")
	private boolean availability_status;
	
	@Column(name="BOOK_TYPE")
	private String book_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBook_condition() {
		return book_condition;
	}

	public void setBook_condition(String book_condition) {
		this.book_condition = book_condition;
	}

	public boolean isAvailability_status() {
		return availability_status;
	}

	public void setAvailability_status(boolean availability_status) {
		this.availability_status = availability_status;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	
	

}
