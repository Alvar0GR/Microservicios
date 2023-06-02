package com.servicios.usermicroservice.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.servicios.usermicroservice.model.Car;

@FeignClient(name="car-service")
@RequestMapping("/car")
public interface CarFeignClient {

	@PostMapping()
	Car save(@RequestBody Car car);
	@GetMapping("/userId/{userId}")
	List<Car> getByUserId(@PathVariable("userId") int userId);
}

