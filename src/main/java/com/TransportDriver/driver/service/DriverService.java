package com.TransportDriver.driver.service;

import com.TransportDriver.driver.model.Driver;

import java.util.List;

public interface DriverService {
    public String createDriver(Driver driver);
    public String  updateDriver(Driver driver);
    public String deleteDriver(String Id);
    public Driver getDriver(String Id);
    public List<Driver> getAllDrivers();

    public List<Driver>getByFirstName(String firstName);
}
