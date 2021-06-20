package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
public class Learner implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String imageUrl;
	private String description;
	//	for security
	private String username;
	private String password;
	//  for preferences
//	private Date dob;
	private String gender;
	private String likes;




	//public Learner(){}

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

}
