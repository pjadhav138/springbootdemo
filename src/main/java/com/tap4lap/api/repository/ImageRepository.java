package com.tap4lap.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tap4lap.api.model.ImageData;

public interface ImageRepository extends JpaRepository<ImageData, Integer> {
	Optional<ImageData> findByName(String name);
}