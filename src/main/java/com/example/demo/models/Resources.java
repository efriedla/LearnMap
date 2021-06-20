package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
public class Resources implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long rId;
	String rating;
	String usedFor;

	@ManyToMany
	@JoinTable
			(
					name= "resources",
					joinColumns=@JoinColumn(name = "cId"),
					inverseJoinColumns=@JoinColumn( name = "rId")
			)
	List<Course> courses;

}
