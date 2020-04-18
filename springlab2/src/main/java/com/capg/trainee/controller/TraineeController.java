package com.capg.trainee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.capg.trainee.bean.Trainee;
import com.capg.trainee.service.TraineeService;

@Controller
@RequestMapping("/trainee")
public class TraineeController {

	@Autowired
	TraineeService service;

	@GetMapping("/login")
	public String adminLogin() {
		return "login";
	}

	@GetMapping("/menu")
	public String adminManage() {
		return "menu";
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@GetMapping("/delete")
	public String delete() {
		return "delete";
	}

	@GetMapping("/modify")
	public String modify() {
		return "modify";
	}

	@GetMapping("/retrive")
	public String retrive() {
		return "retrive";
	}

	@GetMapping("/retriveall")
	public String retriveAll() {
		return "retriveall";
	}

	@PostMapping("/addtrainee")

	public ModelAndView addTrainee(@ModelAttribute Trainee trainee) {
		service.addTrainee(trainee);
		return new ModelAndView("addTrainee", "trainee", trainee);
	}

	@PostMapping("/deletetrainee")

	public String deleteTrainee(@RequestParam("traineeId") int traineeId) {
		service.deleteTrainee(traineeId);
		return "trainee deleted";
	}

	@PutMapping("/modifytrainee")

	public ModelAndView modifyTrainee(@RequestParam int traineeId) {
		Trainee trainee=service.retrieveTrainee(traineeId);
		  return new ModelAndView("modify1","trainee",trainee); 
		
	}

	@GetMapping("/retrivetrainee")

	public ModelAndView retrieveTrainee(@RequestParam("traineeId") int id) {
		 return new ModelAndView("retrieveTrainee","trainee", service.retrieveTrainee(id));
	}

	@GetMapping("/retriveallTrainee")
	public ModelAndView retriveAllTrainee() {
		return new ModelAndView("retrieveAllTrainee","traineeList",service.retrieveAllTrainee());
	}
}
