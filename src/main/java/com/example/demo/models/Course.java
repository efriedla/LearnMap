package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
@AllArgsConstructor
@ToString
@Table
//@Component //spring boot component
public class Course implements Serializable {
	static final long serialVersionUID = 6381462249347345007L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long cId;
	String topic;
	String cName;
	String cDescription;
	String cResources;
	String cUsedFor;
	String cStatus;
	Date timeLine;
	Date lastActive;
	String rating;

	public Course(String cName) {
		this.cName = cName;
	}

	// courses can have many learners but at the moment will only have one till they are ready to be shared
	@ManyToMany
	@JoinTable (
			name="learner_course",
			inverseJoinColumns=@JoinColumn(name = "username"),
			joinColumns=@JoinColumn(name = "cId")
	)
	List<Learner> learners;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	List<CourseTask> tasks;

	@ManyToMany
	@JoinTable
			(
					name= "resources",
					joinColumns=@JoinColumn(name = "rId"),
					inverseJoinColumns=@JoinColumn( name = "cId")
			)
	List<Resources> resources;

}
