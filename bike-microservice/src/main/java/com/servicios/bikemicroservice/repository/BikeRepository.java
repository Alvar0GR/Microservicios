package com.servicios.bikemicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicios.bikemicroservice.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Integer> {

	List<Bike> findByUserId(int userId);
}
