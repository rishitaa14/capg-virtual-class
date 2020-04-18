package com.capg.trainee.controller;

import java.util.List;

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
		return "retrieve";
	}

	@GetMapping("/retriveall")
	public String retriveAll() {
		return "retrieveall";
	}

	@PostMapping("/addtrainee")

	public String addTrainee(@ModelAttribute Trainee trainee, Model m) {

		Trainee train = service.addTrainee(trainee);
		m.addAttribute("train", train);
		return "Trainee added";

	}

	@PostMapping("/deletetrainee")

	public String deleteTrainee(@RequestParam("traineeId") int traineeId) {
		service.deleteTrainee(traineeId);
		return "trainee deleted";
	}

	@PutMapping("/modifytrainee")

	public String modifyTrainee(@ModelAttribute Trainee trainee) {
		service.updateTrainee(trainee);

		return "trainee updated";
	}

	@GetMapping("/retrievetrainee")
	public ModelAndView retrieveTrainee(@RequestParam("traineeId") int id) {
		return new ModelAndView("retrieveTrainee", "trainee", service.retrieveTrainee(id));
	}

	@GetMapping("/retrieveallTrainee")

	public ModelAndView retrieveAllTrainee() {
		return new ModelAndView("retrieveAllTrainee", "traineeList", service.retrieveAllTrainee());
	}
}
