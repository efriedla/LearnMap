package com.example.demo.dao;
/*
        - add annotation
        - extend spring jpa
        - add custom methods if needed
 */

import com.example.demo.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILearnerRepo extends JpaRepository<Learner, Long> {

	void deleteLearnerById(Long id);

	Learner findLearnerById(Long id);


	Optional<Learner> findLearnerByEmail(String lEmail);

	Learner findLearnerByUsername(String username);

}
