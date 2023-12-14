package com.parkauto.parkauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkauto.parkauto.entity.Location;

public interface ILocationRepository extends JpaRepository<Location, Long> {

}
