package com.servicios.carmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.carmicroservice.entity.Car;
import com.servicios.carmicroservice.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService carService;
	
	@GetMapping
	public ResponseEntity<List<Car>> getAll(){
		List<Car> cars = carService.getAll();
		if(cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getById(@PathVariable("id") int id){
		Car car = carService.getUserById(id);
		if(car == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(car);
	}
	
	@PostMapping("")
	public ResponseEntity<Car> save(@RequestBody Car car){
		Car carNew = carService.save(car);
		return ResponseEntity.ok(carNew);
	}

	@GetMapping("/userId/{userId}")
	public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId){
		List<Car> cars = carService.getByUserId(userId);
		return ResponseEntity.ok(cars);
	}
}