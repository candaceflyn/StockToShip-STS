package com.ttida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttida.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    boolean existsById(Long locationId);
}

