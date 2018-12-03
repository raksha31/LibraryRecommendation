package zenjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
		name = "book",
		uniqueConstraints = @UniqueConstraint(name = "uc_isbn", columnNames = {"isbn"})
		)
public class Book {
	@Id
	@GeneratedValue
	 Long id;
	@Column(nullable = false)
	 private String isbn;
	@Column(nullable = false, length=300)
	 private String title;
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	private Integer categoryId;

}