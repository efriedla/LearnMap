package com.example.demo;

import com.example.demo.dao.ILearnerRepo;
import com.example.demo.models.Learner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LearnerConfig {

	@Bean
	CommandLineRunner commandLineRunner(ILearnerRepo repo) {
		return args -> {
			Learner bob = new Learner(
					"bob",
					"man",
					"bob@gmail",
					"phone",
					"https://images.pexels.com/photos/4827667/pexels-photo-4827667.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
					"description of bob"
			);
			Learner jim = new Learner(
					"jim",
					"man",
					"jim@gmail",
					"phone",
					"https://images.pexels.com/photos/4827667/pexels-photo-4827667.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
					"description of jim"
			);
			Learner alex = new Learner(
					"Alex",
					"fjksdf",
					"Alex@gmail",
					"phone",
					"https://images.pexels.com/photos/4827667/pexels-photo-4827667.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
					"description of jim"
			);
			repo.saveAll(
					List.of(bob,jim,alex)
			);

		};
	}
}
