package com.TransportDriver.driver.repository;

import com.TransportDriver.driver.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, String> {
    List<Driver> findByFirstName(String firstName);
}
