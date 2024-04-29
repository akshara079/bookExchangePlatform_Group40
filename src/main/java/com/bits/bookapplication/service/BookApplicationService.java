package com.bits.bookapplication.service;

import java.util.List;

import com.bits.bookapplication.to.BookTO;
import com.bits.bookapplication.to.BookUpdateTO;
import com.bits.bookapplication.to.UserTO;
import com.bits.bookapplication.to.UserUpdateTO;

public interface BookApplicationService {
	
	
	List<BookTO> getBookDetails();
	
	BookTO addBookDetails(BookTO bookTO);
	
	BookTO updateBookDetails(BookUpdateTO bookTO) throws Exception;
	
	boolean deleteBookDetails(String title);


	
	List<UserTO> getUserDetails(String userName);
	
	UserTO addUserDetails(UserTO userTO);

	
	UserTO updateUserDetails(UserUpdateTO userTO) throws Exception;
	boolean deleteUserDetails(String username);





}
