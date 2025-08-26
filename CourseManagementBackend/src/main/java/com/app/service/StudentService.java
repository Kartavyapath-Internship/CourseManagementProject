package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface StudentService {
	    Student addStudent(Student student);
	    Student updateStudent(Integer id, Student student);
	    void deleteStudent(Integer id);
	    Student getStudentById(Integer id);
	    List<Student> getAllStudents();
}
