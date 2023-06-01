package com.servicios.usermicroservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.servicios.usermicroservice.model.Bike;
import com.servicios.usermicroservice.model.Car;

@FeignClient(name="bike-microservice", url="http://localhost:8003/bike")
public interface BikeFeignClient {

	@PostMapping()
	Bike save(@RequestBody Bike bike);
	@GetMapping("/userId/{userId}")
	List<Bike> getByUserId(@PathVariable("userId") int userId);
}
