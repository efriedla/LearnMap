package com.example.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

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
public class Course implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long courseId;
	private String topic;
	private String cName;
	private String cDescription;
	private String cResources;
	private String cUsedFor;
	private String cStatus;
	private Date timeLine;
	private Date lastActive;
	private String rating;
}
