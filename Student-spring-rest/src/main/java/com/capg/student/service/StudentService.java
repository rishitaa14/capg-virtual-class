package com.capg.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.student.model.Student;
import com.capg.student.repo.IStudentRepo;

@Service
public class StudentService {

	@Autowired
	IStudentRepo repo;
	

    @Transactional
	public Student addStudent(Student student) {
		return repo.save(student);
	}
	
	@Transactional
    public boolean deleteStudent(int studentId) {
		repo.deleteById(studentId);
		return !repo.existsById(studentId);
		
	}
	
	public Student getStudent(int studentId) {
		return repo.getOne(studentId);
	}
	
	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	
	@Transactional
	public Student getByStudentName(String studentName) {
		return repo.getByStudentName(studentName);
	}
	
	
	
}
