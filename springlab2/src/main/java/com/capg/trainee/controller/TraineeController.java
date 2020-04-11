package com.capg.trainee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	/*
	 * @GetMapping("/manage") public String adminManage() { return "manage"; }
	 */

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
	//@ResponseBody
	public String addTrainee(@ModelAttribute Trainee trainee, Model m) 
	{

		Trainee train = service.addTrainee(trainee);
		m.addAttribute(train);
		return "Trainee added";
       
	}

	@PostMapping("/deletetrainee")
	@ResponseBody
	public String deleteTrainee(@RequestParam("traineeId") int traineeId) {
		service.deleteTrainee(traineeId);
		return "trainee deleted";
	}

	@PutMapping("/modifytrainee")
	@ResponseBody
	public String modifyTrainee() {
		return "trainee updated";
	}

	@GetMapping("/retrivetrainee")
	@ResponseBody
	public String retriveTrainee() {
		return "trainee retrived";
	}

	@GetMapping("/retriveallTrainee")
	@ResponseBody
	public String retriveAllTrainee() {
		return "all trainee's retrived ";
	}
}
