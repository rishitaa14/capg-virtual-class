package com.capg.trainee.service;


import java.util.List;

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
		 Trainee newTrainee=repo.getOne(trainee.getTraineeId());
		    newTrainee.setTraineeName(trainee.getTraineeName());
		    newTrainee.setTraineeLocation(trainee.getTraineeLocation());
		    newTrainee.setTraineeDomain(trainee.getTraineeDomain());
		    repo.save(newTrainee);
			return trainee;
	}

	public boolean deleteTrainee(int traineeId) {
		repo.deleteById(traineeId);
		return !repo.existsById(traineeId);

	}

	public Trainee retrieveTrainee(int traineeId) {
		
		return repo.getOne(traineeId);
	}
	
	public List<Trainee> retrieveAllTrainees(){
		return repo.findAll();
	}

}
