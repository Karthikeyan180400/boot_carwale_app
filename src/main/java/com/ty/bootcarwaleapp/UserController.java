package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);

	}

	@GetMapping("/getalluser")
	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	@PostMapping("/updateuser/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return userRepository.save(user);
		}
	}

	@GetMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			return "No User to delete";
		} else {
			userRepository.delete(optional.get());
			return "User Deleted";
		}

	}

	@GetMapping("/useremail")
	public List<User> getUserByEmail(@RequestParam String email) {
		return userRepository.findByEmail(email);

	}

	@GetMapping("/userphone/{phone}")
	public List<User> getUserByPhone(@PathVariable long phone) {
		return userRepository.findByPhone(phone);
	}

	@GetMapping("/userrole/{role}")
	public List<User> getUserByRole(@PathVariable String role) {
		return userRepository.findByRole(role);

	}

	@GetMapping("/user")
	public List<User> getUserByGenderAndRole(@RequestParam String gender, @RequestParam String role) {
		return userRepository.findByGenderAndRole(gender, role);
	}
	
	@GetMapping("/validateuser")
	public List<User> validateUser(@RequestParam String email, @RequestParam String password) {
		return userRepository.validateUser(email, password);
		
	}

}
