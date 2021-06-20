package com.example.demo.dao;
/*
        - add annotation
        - extend spring jpa
        - add custom methods if needed
 */

import com.example.demo.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ILearnerRepo extends JpaRepository<Learner, Long> {

	void deleteLearnerById(Long id);

	Learner findLearnerById(Long id);
	Learner findLearnerByUsername(String username);

	Optional<Learner> findBysUsername(String s);
}
