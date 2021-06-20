package com.example.demo.models;

import lombok.*;

import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;


	@Entity
	@Data
	@NoArgsConstructor
	@RequiredArgsConstructor
	@FieldDefaults(level = AccessLevel.PRIVATE)
	@Component
	public class AuthGroup implements Serializable {
		private static final long serialVersionUID = 8349938216666765198L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long aId;
		@NonNull @NotBlank
		String aUsername;
		@NonNull @NotBlank
		String aAuthGroup;
	}


