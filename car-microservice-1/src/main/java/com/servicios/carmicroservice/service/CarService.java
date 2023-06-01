package com.servicios.carmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicios.carmicroservice.entity.Car;
import com.servicios.carmicroservice.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;
	
	public List<Car> getAll(){
		return carRepository.findAll();
	}
	public Car getUserById(int id) {
		return carRepository.findById(id).orElse(null);
	}

	public Car save(Car car) {
		Car carNew = carRepository.save(car);
		return carNew;
	}
	public List<Car> getByUserId(int id){
		return carRepository.findByUserId(id);
	}
	
}