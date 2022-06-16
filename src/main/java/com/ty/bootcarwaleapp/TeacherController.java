package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

	@Autowired
	TeacherRepository teacherRepository;

	@PostMapping("/saveteacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return teacherRepository.save(teacher);

	}

	@GetMapping("/teacher")
	public Teacher getTeacherById(@RequestParam int id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	@GetMapping("/getallteacher")
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}

	@PostMapping("/updateteacher")
	public Teacher updateTeacher(@RequestParam int id, @RequestBody Teacher teacher) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return teacherRepository.save(teacher);
		}

	}

	@GetMapping("/deleteteacher")
	public String deleteTeacher(@RequestParam int id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		if (optional.isEmpty()) {
			return "No Teacher to delete";
		} else {
			teacherRepository.delete(optional.get());
			return "Teacher Deleted";
		}
	}
}
