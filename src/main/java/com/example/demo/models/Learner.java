package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Learner implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long id;
	String firstName;
	String lastName;
	String email;
	String phone;
	String imageUrl;
	String description;
	//	for security
	String username;
	String password;
	//  for preferences
//	Date dob;
	String gender;
	String likes;
	//learner can have many courses, and in the future can share the corse so the course can have many learners



	public Learner(String firstName, String lastName, String email, String phone, String imageUrl, String description, String username, String password, String gender, String likes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.description = description;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.likes = likes;
	}

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
	List<Course> courses;

}
