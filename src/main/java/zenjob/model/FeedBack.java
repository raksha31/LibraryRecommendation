package zenjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(
		name = "feedback"
		)
public class FeedBack {
	@Id
	@GeneratedValue
	 Long id;
	private Long userId;
	private Long bookId;
	@Column(length=300)
	private String feedback;

	public FeedBack(Long userId, Long bookId, String feedback) {
		this.userId = userId;
		this.bookId = bookId;
		this.feedback = feedback;
	}
}
