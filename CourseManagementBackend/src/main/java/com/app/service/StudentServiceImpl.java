package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{
	 @Autowired
	    private StudentDao studentDao;

	    @Override
	    public Student addStudent(Student student) {
	        return studentDao.save(student);
	    }

	    @Override
	    public Student updateStudent(Integer id, Student student) {
	        Optional<Student> existingStudent = studentDao.findById(id);
	        if (existingStudent.isPresent()) {
	            Student updated = existingStudent.get();
	            updated.setName(student.getName());
	            updated.setPassword(student.getPassword());
	            updated.setEmail(student.getEmail());
	            updated.setMobileNo(student.getMobileNo());
	            updated.setRegistrationNo(student.getRegistrationNo());
	            updated.setCourse(student.getCourse());
	            updated.setBatch(student.getBatch());
	            updated.setGroup(student.getGroup());
	            return studentDao.save(updated);
	        }
	        return null; // or throw exception
	    }

	    @Override
	    public void deleteStudent(Integer id) {
	        studentDao.deleteById(id);
	    }

	    @Override
	    public Student getStudentById(Integer id) {
	        return studentDao.findById(id).orElse(null);
	    }

	    @Override
	    public List<Student> getAllStudents() {
	        return studentDao.findAll();
	    }
}
