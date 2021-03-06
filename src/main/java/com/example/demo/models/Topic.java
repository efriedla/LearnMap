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
//@Component //spring boot component
public class Topic implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long topicId;
	@NonNull @Column(unique = true)
	private String tName;
	private String tDescription;
	private String courses;
	private Date lastActive;
	private String tResources;
	private String tRating;
	private String status;
}
