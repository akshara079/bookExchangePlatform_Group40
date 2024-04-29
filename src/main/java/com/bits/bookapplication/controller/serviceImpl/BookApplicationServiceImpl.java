package com.bits.bookapplication.controller.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.bookapplication.dao.BookDAO;
import com.bits.bookapplication.dao.UserDAO;
import com.bits.bookapplication.entities.BookEntity;
import com.bits.bookapplication.entities.UserEntity;
import com.bits.bookapplication.service.BookApplicationService;
import com.bits.bookapplication.to.BookTO;
import com.bits.bookapplication.to.BookUpdateTO;
import com.bits.bookapplication.to.UserTO;
import com.bits.bookapplication.to.UserUpdateTO;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private BookDAO bookDao;

	public List<BookTO> getBookDetails() {
		List<BookTO> bookTOList = new ArrayList<>();
		Iterable<BookEntity> bookDetails = bookDao.findAll();

		for (BookEntity book : bookDetails) {
			BookTO bookTO = new BookTO();
			bookTO.setId(book.getId());
			bookTO.setUser_id(book.getUser_id());
			bookTO.setTitle(book.getTitle());
			bookTO.setGenre(book.getGenre());
			bookTO.setDescription(book.getDescription());
			bookTO.setBook_type(book.getBook_type());
			bookTO.setBook_condition(book.getBook_condition());
			bookTO.setAvailability_status(book.isAvailability_status());
			bookTO.setAuthor(book.getAuthor());
			bookTOList.add(bookTO);

		}

		return bookTOList;
	}

	@Override
	public BookTO addBookDetails(BookTO bookTO) {

		BookEntity bookEntity = new BookEntity();

		BookTO bookDetails = new BookTO();
		bookEntity.setAuthor(bookTO.getAuthor());
		bookEntity.setAvailability_status(bookTO.isAvailability_status());
		bookEntity.setBook_condition(bookTO.getBook_condition());
		bookEntity.setBook_type(bookTO.getBook_type());
		bookEntity.setDescription(bookTO.getDescription());
		bookEntity.setGenre(bookTO.getGenre());
		bookEntity.setTitle(bookTO.getTitle());
		bookEntity.setUser_id(bookTO.getUser_id());
		// TODO Auto-generated method stub
		bookDao.save(bookEntity);

		bookDetails.setAuthor(bookTO.getAuthor());
		bookDetails.setAvailability_status(bookTO.isAvailability_status());
		bookDetails.setBook_condition(bookTO.getBook_condition());
		bookDetails.setBook_type(bookTO.getBook_type());
		bookDetails.setDescription(bookTO.getDescription());
		bookDetails.setGenre(bookTO.getGenre());
		bookDetails.setTitle(bookTO.getTitle());
		bookDetails.setUser_id(bookTO.getUser_id());

		return bookDetails;
	}

	@Override
	public BookTO updateBookDetails(BookUpdateTO bookTO) throws Exception {

		int n = bookDao.checkIfBookExist(bookTO.getTitle());
		if (n == 0) {
			throw new Exception("The given book doesnt exist");

		}
		BookEntity bookEntity = bookDao.findByTitle(bookTO.getTitle()).get();

		BookTO bookDetails = new BookTO();
		if(!(bookTO.getAuthor()==null)) bookEntity.setAuthor(bookTO.getAuthor());
		
		//how to compare availability status
		if(bookTO.isAvailability_status() != bookEntity.isAvailability_status()) bookEntity.setAvailability_status(bookTO.isAvailability_status());
		if(!(bookTO.getBook_condition()==null)) bookEntity.setBook_condition(bookTO.getBook_condition());
		if(!(bookTO.getBook_type()==null)) bookEntity.setBook_type(bookTO.getBook_type());
		if(!(bookTO.getDescription()==null)) bookEntity.setDescription(bookTO.getDescription());
		if(!(bookTO.getGenre()==null))bookEntity.setGenre(bookTO.getGenre());
		if(!(bookTO.getUpdated_title()==null)) bookEntity.setTitle(bookTO.getUpdated_title());
		bookDao.save(bookEntity);

		bookDetails.setAuthor(bookEntity.getAuthor());
		bookDetails.setAvailability_status(bookEntity.isAvailability_status());
		bookDetails.setBook_condition(bookEntity.getBook_condition());
		bookDetails.setBook_type(bookEntity.getBook_type());
		bookDetails.setDescription(bookEntity.getDescription());
		bookDetails.setGenre(bookEntity.getGenre());
		bookDetails.setTitle(bookEntity.getTitle());
		bookDetails.setUser_id(bookEntity.getUser_id());

		return bookDetails;

	}

	public boolean deleteBookDetails(String title) {

		Integer n = bookDao.deleteUserByTitle(title);
		if (n.equals(0)) {
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<UserTO> getUserDetails(String userName) {
		List<UserTO> userTO = new ArrayList<>();
		UserEntity userDetails = userDao.findByUsername(userName).get();

		UserTO userTo = new UserTO();
		userTo.setId(userDetails.getId());
		userTo.setEmail(userDetails.getEmail());
		userTo.setName(userDetails.getName());
		userTo.setPassword(userDetails.getPassword());
		userTo.setUsername(userDetails.getUsername());

		userTO.add(userTo);

		return userTO;
	}
	
	@Override
	public UserTO addUserDetails(UserTO userTO) {
		UserEntity userEntity = new UserEntity();

		UserTO userDetails = new UserTO();
		userEntity.setEmail(userTO.getEmail());
		userEntity.setName(userTO.getName());
		userEntity.setPassword(userTO.getPassword());
		userEntity.setUsername(userTO.getUsername());
		userDao.save(userEntity);

		userDetails.setEmail(userTO.getEmail());
		userDetails.setName(userTO.getName());
		userDetails.setPassword(userTO.getPassword());
		userDetails.setUsername(userTO.getUsername());

		return userDetails;
	}

	@Override
	public UserTO updateUserDetails(UserUpdateTO userTO) throws Exception {
		int n = userDao.checkIfUserExist(userTO.getUsername());
		if (n == 0) {
			throw new Exception("The given user doesnt exist");

		}
		UserEntity userEntity = userDao.findByUsername(userTO.getUsername()).get();
		
		if(!(userTO.getPassword()==null))userEntity.setPassword(userTO.getPassword());
		if(!(userTO.getEmail()==null))userEntity.setEmail(userTO.getEmail());
		if(!(userTO.getUsername_updated()==null))userEntity.setUsername(userTO.getUsername_updated());
		if(!(userTO.getName()==null))userEntity.setName(userTO.getName());
		userDao.save(userEntity);


		UserTO userDetails = new UserTO();
		userDetails.setEmail(userEntity.getEmail());
		userDetails.setName(userEntity.getName());
		userDetails.setPassword(userEntity.getPassword());
		userDetails.setUsername(userEntity.getUsername());

		return userDetails;
	}

	@Override
	public boolean deleteUserDetails(String username) {
		Integer n = userDao.deleteUserByUsername(username);
		if (n.equals(0)) {
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

	

}
