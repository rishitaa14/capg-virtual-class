package com.capg.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.student.model.Student;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer> {
	
	public Student getByStudentName(String studentName);

}
