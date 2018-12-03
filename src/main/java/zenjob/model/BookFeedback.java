package zenjob.model;

import javax.annotation.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Resource
public class BookFeedback {
	private String title;
	private String feedback;
}
