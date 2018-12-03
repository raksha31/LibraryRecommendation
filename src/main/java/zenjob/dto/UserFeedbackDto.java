package zenjob.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zenjob.model.BookFeedback;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserFeedbackDto {
private String username;
private List<BookFeedback> booksFeedback;
}
