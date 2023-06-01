package com.servicios.usermicroservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicios.usermicroservice.entity.User;
import com.servicios.usermicroservice.feignclients.BikeFeignClient;
import com.servicios.usermicroservice.feignclients.CarFeignClient;
import com.servicios.usermicroservice.model.Bike;
import com.servicios.usermicroservice.model.Car;
import com.servicios.usermicroservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CarFeignClient carFeignClient;
	
	@Autowired
	BikeFeignClient bikeFeignClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		User userNew = userRepository.save(user);
		return userNew;
	}
	public List<Car> getCars(int userId){
		List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/userId/"+ userId, List.class);
		return cars;
	}
	public List<Bike> getBikes(int userId){
		List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/userId/"+ userId, List.class);
		return bikes;
	}
	public Car saveCar(int userId,Car car) {
		car.setUserId(userId);
		Car carNew = carFeignClient.save(car);
		return carNew;
	}
	public Bike saveBike(int userId, Bike bike) {
		bike.setUserId(userId);
		Bike bikeNew = bikeFeignClient.save(bike);
		return bikeNew;
	}
	public Map<String, Object> getUserAndVehicles(int userId){
		Map<String,Object> result = new HashMap<>();
		User user = userRepository.findById(userId).orElse(null);
		if(user==null) {
			result.put("Mensaje", "No existe el usuario");
			return result;
		}
		result.put("User", user);
		List<Car> cars = carFeignClient.getByUserId(userId);
		if(cars.isEmpty()) {
			result.put("Cars", "el usuario no tiene coches");
		}else {
			result.put("Cars", cars);
		}
		List<Bike> bikes = bikeFeignClient.getByUserId(userId);
		if(bikes.isEmpty()) {
			result.put("Bikes", "el usuario no tiene motos");
		}else {
			result.put("Bikes", bikes);
		}
		return result;
	}
}
