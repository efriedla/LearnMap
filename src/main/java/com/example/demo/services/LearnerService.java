package com.example.demo.services;
 /*
            - add class annotations
            - add @Transactional on class or on each method
            - add crud methods
     */

import com.example.demo.dao.ILearnerRepo;
import com.example.demo.models.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class LearnerService {
	private final ILearnerRepo learnerRepo;

	@Autowired
	public LearnerService(ILearnerRepo learnerRepo) {
		this.learnerRepo = learnerRepo;
	}

	public Learner addLearner(Learner learner){
		return learnerRepo.save(learner);
	}

	public List<Learner> findAllLearners(){
		return learnerRepo.findAll();
	}

	public Learner updateLearner(Learner learner){
		return  learnerRepo.save(learner);
	}

	public Learner findLearnerById(Long id){
//		return learnerRepo.findLearnerById(id).orElseThrow(() -> new UserPrincipalNotFoundException("User by id " + id + " was not found"));
		return learnerRepo.findLearnerById(id);
	}

	public void deleteLearner(Long id){
		learnerRepo.deleteLearnerById(id);
	}



}
