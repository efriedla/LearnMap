package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

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
@Component
public class Resources implements Serializable {
	private static final long serialVersionUID = -6882321928678677628L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long rId;
	String rating;
	String usedFor;


	@ManyToMany
	@JoinTable
			(
					name= "coursesr",
					joinColumns=@JoinColumn(name = "cId"),
					inverseJoinColumns=@JoinColumn( name = "rId")
			)
	//@ToString.Exclude
	List<Course> coursesr;

}
