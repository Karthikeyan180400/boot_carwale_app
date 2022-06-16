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
public class CarController {

	@Autowired
	CarRepository carRepository;

	@PostMapping("/savecar")
	public Car saveCar(@RequestBody Car car) {
		return carRepository.save(car);

	}

	@GetMapping("/getall")
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}

	@GetMapping("/car/{id}")
	public Car getCarById(@PathVariable int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	@GetMapping("/delete")
	public String deleteCar(@RequestParam int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isEmpty()) {
			return "No car to delete";
		} else {
			Car car = optional.get();
			carRepository.delete(car);
			return "Car Deleted";
		}
	}

	@PostMapping("/update")
	public Car updateCar(@RequestParam int id, @RequestBody Car car) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return carRepository.save(car);
		}

	}

}
