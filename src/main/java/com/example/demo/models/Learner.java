package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Learner implements Serializable {
	private static final long serialVersionUID = -2413271188862611207L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	Long id;
	String firstName;
	String lastName;
//	@Email(regexp = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b",message = "Invalid email address")
	String email;
	String phone;
	String imageUrl;
	String description;
	//	for security
//	@Length(min = 3, max = 25, message = "should be between {1} and {2}")
//	@NotBlank(message = "Please Enter a Username")
	String username;
//	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "- at least 8 characters\n- must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number\n- Can contain special characters")
	String password;
	//  for preferences
//	Date dob;
	String gender;
	String likes;
	//learner can have many courses, and in the future can share the corse so the course can have many learners



//	public Learner(String firstName, String lastName, String email, String phone, String imageUrl, String description, String username, String password, String gender, String likes) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.phone = phone;
//		this.imageUrl = imageUrl;
//		this.description = description;
//		this.username = username;
//		this.password = password;
//		this.gender = gender;
//		this.likes = likes;
//	}

	public Learner(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@ManyToMany
	@JoinTable
			(
					name= "student_course",
					joinColumns=@JoinColumn(name = "username"),
					inverseJoinColumns=@JoinColumn( name = "cId")
			)
			@ToString.Exclude
	List<Course> courses;



}
