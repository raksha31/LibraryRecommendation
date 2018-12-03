package zenjob;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import zenjob.dao.BookRepository;
import zenjob.dao.UserRepository;
import zenjob.dto.UserDto;
import zenjob.dto.UserFeedbackDto;
import zenjob.model.Book;
import zenjob.model.BookFeedback;
import zenjob.model.User;

import com.jayway.restassured.http.ContentType;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = App.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ZenjobRestControllerTest {

	int port = 50051;
	UserDto user;
	UserFeedbackDto feedbackDto;
	List<BookFeedback> booksFeedback;
	List<String> categories;

	@Test
	public void createUser_RestCall() {
		categories = new ArrayList<>();
		categories.add("Children's Books");
		categories.add("Literature & Fiction");
		user = new UserDto("raksha@yopmail.com",26,categories);
		given()
		.body(user)
		.when()
		.contentType(ContentType.JSON)
		.port(port).post("/library/user/register").prettyPeek().
		then()
		.statusCode(200);
	}

}


