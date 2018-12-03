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
		name = "user",
		uniqueConstraints = @UniqueConstraint(name = "uc_username", columnNames = {"username"})
		)

public class User {
	@Id
	@GeneratedValue
	Long id;

	@Column(nullable = false)
	private String username;

	private int age;

	public User(String username, int age) {
		this.username = username;
		this.age = age;
	}
}
