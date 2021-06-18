package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Getter
//@Setter
//@NoArgsConstructor
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity //database
//@Component //spring boot component
public class CourseTask implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long ctId;
	private String ctName;
	private String ctUsedFor;
	private String importance;
	private String rating;
	private Date timeLine;
	private String resources;







}
