/**
 *
 */
package zenjob.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import zenjob.config.CategoryMapper;
import zenjob.dao.BookRepository;
import zenjob.dao.FeedBackRepository;
import zenjob.dao.UserRepository;
import zenjob.dto.UserDto;
import zenjob.dto.UserFeedbackDto;
import zenjob.exception.BooksNotFoundException;
import zenjob.exception.CategoryAllowedExceedException;
import zenjob.exception.CategoryNotFoundException;
import zenjob.exception.UserAlreadyExistException;
import zenjob.exception.UserNotFoundException;
import zenjob.model.Book;
import zenjob.model.BookFeedback;
import zenjob.model.FeedBack;
import zenjob.model.User;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {

	@Autowired
	public CategoryMapper categoryMapper;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	FeedBackRepository feedBackRepository;


	@Override
	public void getUserFeedback(UserFeedbackDto userFeedback) {
		List<FeedBack> feedBacks = new ArrayList<>();
		User user = userRepository.findByUsername(userFeedback.getUsername());
		if(user == null) {
			throw new UserNotFoundException();
		}
		for(BookFeedback feedback : userFeedback.getBooksFeedback()) {
			Book book = bookRepository.findByTitle(feedback.getTitle());
			if(book == null) {
				throw new BooksNotFoundException();
			}
			FeedBack feedBack = new FeedBack(user.getId(), book.getId(), feedback.getFeedback());
			feedBacks.add(feedBack);
		}
		feedBackRepository.saveAll(feedBacks);

	}
	@Override
	public List<Book> createLibraryUser(UserDto newUser) {
		registerNewUser(newUser);
		List<Book> recommendedBooks = new ArrayList<>();
		if(newUser.getCategories().size() > 5) {
			throw new CategoryAllowedExceedException();
		}
		getRecommendedBooks(newUser, recommendedBooks);
		if(recommendedBooks.isEmpty()) {
			throw new BooksNotFoundException();
		}
		return recommendedBooks;
	}


	/**
	 * @param newUser
	 */
	private void registerNewUser(UserDto newUser) {
		User user = userRepository.findByUsername(newUser.getUsername());
		if(user != null) {
			throw new UserAlreadyExistException();
		}
		 user = new User(newUser.getUsername(), newUser.getAge());
		userRepository.save(user);
	}


	/**
	 * @param newUser
	 * @param recommendedBooks
	 */
	private void getRecommendedBooks(UserDto newUser,
			List<Book> recommendedBooks) {
		List<String> requestedCategories = newUser.getCategories();
		int booksPerCategory = 20 / requestedCategories.size();
		for(String category : requestedCategories) {
			Integer categoryId = categoryMapper.getCategoryMap().get(category);
			if(categoryId == null){
				throw new CategoryNotFoundException();
			}
			List<Book> booksForCategory = bookRepository.findBooksByCategory(categoryId, PageRequest.of(0,booksPerCategory));
			if(booksForCategory.size() < booksPerCategory) {
				booksPerCategory += booksPerCategory-booksForCategory.size();
			}
			recommendedBooks.addAll(booksForCategory);
		}
	}



}