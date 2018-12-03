/**
 *
 */
package zenjob.service;

import java.util.List;

import org.springframework.data.domain.Page;

import zenjob.dto.UserDto;
import zenjob.dto.UserFeedbackDto;
import zenjob.model.Book;

/**
 * @author Raksha
 *
 */
public interface LibraryUserService {
	public List<Book> createLibraryUser(UserDto newUser);
	public void getUserFeedback(UserFeedbackDto userFeedback);
}
