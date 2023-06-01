package com.servicios.usermicroservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicios.usermicroservice.model.Bike;

@FeignClient(name="bike-microservice")
@RequestMapping("/bike")
public interface BikeFeignClient {

	@PostMapping()
	Bike save(@RequestBody Bike bike);
	@GetMapping("/userId/{userId}")
	List<Bike> getByUserId(@PathVariable("userId") int userId);
}
