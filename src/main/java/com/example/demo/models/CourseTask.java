package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
//@Component //spring boot component
public class CourseTask implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long ctId;
	String ctName;
	String ctUsedFor;
	String importance;
	String step;
	Date timeLine;
	String resources;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cId", nullable = false)
	Course course;









}
