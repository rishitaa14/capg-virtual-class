package com.capg.trainee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.trainee.bean.Trainee;
import com.capg.trainee.dao.ITraineeRepo;
@Service
public class TraineeService {

	@Autowired
	ITraineeRepo repo;
	
	
	public Trainee addTrainee(Trainee trainee) {
		return repo.save(trainee);
	}


	public Trainee updateTrainee(Trainee trainee) {
		return repo.save(trainee);
	}

	public void deleteTrainee(int traineeId) {
		repo.deleteById(traineeId);

	}

	public Trainee retriveTrainee(int traineeId) {
		
		return repo.getOne(traineeId);
	}

}
