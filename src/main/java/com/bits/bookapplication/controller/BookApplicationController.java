package com.bits.bookapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bits.bookapplication.service.BookApplicationService;
import com.bits.bookapplication.to.BookTO;
import com.bits.bookapplication.to.BookUpdateTO;
import com.bits.bookapplication.to.UserTO;
import com.bits.bookapplication.to.UserUpdateTO;

@Controller
public class BookApplicationController {

	@Autowired
	private BookApplicationService bookApplicationService;

	// To get all the book details present in the application
	@GetMapping(path = "/getAllBookDetails/api/v1/books")
	public ResponseEntity<Object> getBookDetails() {
		List<BookTO> bookDetails = bookApplicationService.getBookDetails();
		Map<String, Object> result = new HashMap<>();
		if (bookDetails == null) {
			result.put("Status", "No data found");
		} else {
			result.put("Status", "Success");
			result.put("data", bookDetails);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	// To add book details
	@PostMapping(path = "/addBookDetails/api/v1/books")
	public ResponseEntity<Object> addBookDetails(@RequestBody BookTO bookTO) {
		BookTO bookDetails = bookApplicationService.addBookDetails(bookTO);
		Map<String, Object> result = new HashMap<>();
		if (bookDetails == null) {
			result.put("Status", "No data found");
		} else {
			result.put("Status", "New Details Added");
			result.put("data", bookDetails);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	// To add book details
	@PutMapping(path = "/updateBookDetails/api/v1/books")
	public ResponseEntity<Object> updateBookDetails(@RequestBody BookUpdateTO bookTO) {

		Map<String, Object> result = new HashMap<>();

			if (bookTO.getTitle()==null) {
				result.put("Status", "Provide title details of the book");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
			}
		BookTO bookDetails;
		try {
			bookDetails = bookApplicationService.updateBookDetails(bookTO);

			if (bookDetails == null) {
				result.put("Status", "No data found");
			} else {
				result.put("Status", "New Details Added");
				result.put("data", bookDetails);
			}
		} catch (Exception e) {
			result.put("No data found", "The given book doesnt exist");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	@DeleteMapping(path = "/deleteBookDetails/api/v1/books")
	public ResponseEntity<Object> deleteBookDetails(@RequestBody BookTO bookTO) {

		Map<String, Object> result = new HashMap<>();

		if (bookTO.getTitle().isBlank()) {
			result.put("Status", "Provide the title of the book to be deleted");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		boolean value = bookApplicationService.deleteBookDetails(bookTO.getTitle());
		if (value == false) {
			result.put("Status", "No data found");
		} else {
			result.put("Status", "Details deleted");
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	// To get a particular user's details
	@GetMapping(path = "/getUserDetails/api/v1/users")
	public ResponseEntity<Object> getUserDetails(@RequestBody UserTO userTO) {
		List<UserTO> userDetails = bookApplicationService.getUserDetails(userTO.getUsername());
		Map<String, Object> result = new HashMap<>();
		if (userDetails == null) {
			result.put("Status", "No data found");
		} else {
			result.put("Status", "Success");
			result.put("data", userDetails);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	// To add book details
	@PostMapping(path = "/addUserDetails/api/v1/users")
	public ResponseEntity<Object> addUserDetails(@RequestBody UserTO userTO) {
		UserTO userDetails = bookApplicationService.addUserDetails(userTO);
		Map<String, Object> result = new HashMap<>();
		if (userDetails == null) {
			result.put("Status", "No data found");
		} else {
			result.put("Status", "New Details Added");
			result.put("data", userDetails);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	// To update a particular user's details
	@PutMapping(path = "/updateUserDetails/api/v1/users")
	public ResponseEntity<Object> updatetUserDetails(@RequestBody UserUpdateTO userTo) {
		UserTO userDetails;
		Map<String, Object> result = new HashMap<>();
		// if user name is not provided throw error
		if(userTo.getUsername()==null) {
			result.put("No data found", "Please provide username");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
			
		}

		try {
			userDetails = bookApplicationService.updateUserDetails(userTo);

			if (userDetails == null) {
				result.put("Status", "No data found");
			} else {
				result.put("Status", "Success");
				result.put("data", userDetails);
			}
		} catch (Exception e) {
			result.put("No data found", "The given user doesnt exist");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}
	
	@DeleteMapping(path = "/deleteUserDetails/api/v1/users")
	public ResponseEntity<Object> deleteUserDetails(@RequestBody UserTO userTO) {

		Map<String, Object> result = new HashMap<>();

		if (userTO.getUsername()==null) {
			result.put("Status", "Provide the title of the book to be deleted");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		boolean value = bookApplicationService.deleteUserDetails(userTO.getUsername());
		if (value == false) {
			result.put("Status", "No data found");
		} else {
			result.put("Status", "Details deleted");
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

}
