package zenjob.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import zenjob.dto.ExceptionResponseDto;


@RestControllerAdvice
@Component("ServiceExceptionHandlerAdvice")
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
	 private ResponseEntity<ExceptionResponseDto> errorResponse(HttpStatus status, HttpHeaders headers, String message) {
	        final ExceptionResponseDto apiError = new ExceptionResponseDto(message, status.value());
	        return ResponseEntity.status(status).headers(headers).body(apiError);
	    }
	    @ExceptionHandler(BooksNotFoundException.class)
	    final ResponseEntity<ExceptionResponseDto> handleBooksNotFoundException(BooksNotFoundException ex) {
	        return errorResponse(HttpStatus.NOT_FOUND, new HttpHeaders(), " No Books available for requested category");
	    }
	    @ExceptionHandler(CategoryNotFoundException.class)
	    final ResponseEntity<ExceptionResponseDto> handleCategoryNotFoundException(CategoryNotFoundException ex) {
	        return errorResponse(HttpStatus.NOT_FOUND, new HttpHeaders(), " Mentioned Category not available in database");
	    }
	    @ExceptionHandler(UserAlreadyExistException.class)
	    final ResponseEntity<ExceptionResponseDto> handleUserAlreadyExistException(UserAlreadyExistException ex) {
	        return errorResponse(HttpStatus.CONFLICT, new HttpHeaders(), "User with this username already exist");
	    }
	    @ExceptionHandler(CategoryAllowedExceedException.class)
	    final ResponseEntity<ExceptionResponseDto> handleCategoryAllowedExceedException(CategoryAllowedExceedException ex) {
	        return errorResponse(HttpStatus.BAD_REQUEST, new HttpHeaders(), "Please provide permitted number of categories only");
	    }
	    @ExceptionHandler(UserNotFoundException.class)
	    final ResponseEntity<ExceptionResponseDto> handleUserNotFoundException(UserNotFoundException ex) {
	        return errorResponse(HttpStatus.NOT_FOUND, new HttpHeaders(), "No user found with this username");
	    }
}
