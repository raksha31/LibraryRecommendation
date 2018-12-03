/**
 *
 */
package zenjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zenjob.dto.UserDto;
import zenjob.dto.UserFeedbackDto;
import zenjob.model.Book;
import zenjob.service.LibraryUserService;
import zenjob.service.LibraryUserServiceImpl;


@RestController
@RequestMapping("/library")
public class LibraryUserController {

	@Autowired
	LibraryUserService libraryUserService;

	@PostMapping("/user/register")
	public List<Book> createUserForLibrary(@RequestBody UserDto newuser) {
			return libraryUserService.createLibraryUser(newuser);
	}
	@PostMapping("/book/feedback")
	public void getUserFeedback(@RequestBody UserFeedbackDto userFeedback) {
		libraryUserService.getUserFeedback(userFeedback);
	}

}
