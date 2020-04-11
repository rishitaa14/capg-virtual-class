package com.capg.student.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.student.model.Student;
import com.capg.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
 
	@Autowired
	StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		service.addStudent(student);
		if(service.getStudent(student.getStudentId())==null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int studentId){
		if(service.deleteStudent(studentId)) {
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents=service.getAllStudents();
		if(allStudents.isEmpty()){
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Student>>(allStudents,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId) {
		Student student= service.getStudent(studentId);
		if(student==null) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	@GetMapping("/search/name/{name}")
	public Student getByStudentName(@PathVariable ("name") String studentName) {
		
		return service.getByStudentName(studentName);
	}
	
	
	
}
