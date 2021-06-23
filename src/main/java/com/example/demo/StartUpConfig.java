package com.example.demo;

import com.example.demo.dao.IAuthGroupRepo;
import com.example.demo.dao.ICourseRepo;
import com.example.demo.dao.ILearnerRepo;
import com.example.demo.models.AuthGroup;
import com.example.demo.models.Course;
import com.example.demo.models.Learner;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Log
@Transactional
public class StartUpConfig implements CommandLineRunner {
	ILearnerRepo learnerRepo;
	ICourseRepo courseRepo;
	IAuthGroupRepo userRepo;

	@Autowired
	public StartUpConfig(ILearnerRepo learnerRepo, ICourseRepo courseRepo, IAuthGroupRepo userRepo) {
		this.learnerRepo = learnerRepo;
		this.courseRepo = courseRepo;
		this.userRepo = userRepo;
	}

	@Override
	public void run(String... args) throws Exception {
	log.info("**** Start adding Learners sql statements ****");
        learnerRepo.save(new Learner("mainUser", "thisEmail@gmail.com", "W0rk12345"));
        learnerRepo.save(new Learner("admin", "admin@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        learnerRepo.save(new Learner("learner_one", "learner_one@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        learnerRepo.save(new Learner("learner_two", "learner_two@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        learnerRepo.save(new Learner("learner_three", "learner_three@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
		learnerRepo.findLearnerById(1L).setImageUrl("https://images.pexels.com/photos/4827667/pexels-photo-4827667.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500");
		learnerRepo.findLearnerByUsername("learner_one").setImageUrl("https://images.pexels.com/photos/4827663/pexels-photo-4827663.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500");

		log.info("**** End of sql statements ****");
		log.info("**** Start adding Courses sql statements ****");
		courseRepo.save(new Course("Java"));
		courseRepo.save(new Course("Database"));
		courseRepo.save(new Course("Spring Boot"));
		courseRepo.save(new Course("HTML & CSS"));
		courseRepo.save(new Course("JavaScript"));
		log.info("**** End of sql statements ****");
		log.info("**** Start adding AuthGroup sql statements ****");
		userRepo.save(new AuthGroup("habboubi", "ROLE_ADMIN"));
		userRepo.save(new AuthGroup("habboubi", "ROLE_USER"));
		userRepo.save(new AuthGroup("habboubi", "WRITE"));
		userRepo.save(new AuthGroup("admin", "ROLE_ADMIN"));
		userRepo.save(new AuthGroup("admin", "ROLE_USER"));
		userRepo.save(new AuthGroup("student_one", "ROLE_USER"));
		userRepo.save(new AuthGroup("student_two", "ROLE_USER"));
		userRepo.save(new AuthGroup("student_three", "ROLE_USER"));
		log.info("**** End of sql statements ****");

	}

	@PostConstruct
	public void constructed(){
		log.warning("StartupRunner Constructed!");
	}
}
