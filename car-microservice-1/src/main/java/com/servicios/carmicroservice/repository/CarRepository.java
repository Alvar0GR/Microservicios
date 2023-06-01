package com.servicios.carmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicios.carmicroservice.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	List<Car> findByUserId(int userId);
}
