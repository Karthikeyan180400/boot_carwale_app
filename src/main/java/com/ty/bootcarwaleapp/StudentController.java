package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/savestudent")
	public Student saveStudent(@RequestBody Student student) {
		return studentRepository.save(student);

	}

	@GetMapping("/getallstudent")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();

	}

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	@PostMapping("/updatestudent/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return studentRepository.save(student);
		}
	}

	@GetMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isEmpty()) {
			return "No Student to delete";
		} else {
			studentRepository.delete(optional.get());
			return "Student Deleted";
		}

	}

}
