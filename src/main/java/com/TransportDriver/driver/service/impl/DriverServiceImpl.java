package com.TransportDriver.driver.service.impl;

import com.TransportDriver.driver.exception.DriverNotFoundException;
import com.TransportDriver.driver.model.Driver;
import com.TransportDriver.driver.repository.DriverRepository;
import com.TransportDriver.driver.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverServiceImpl implements DriverService {
    DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }



    @Override
    public String createDriver(Driver driver) {
        driverRepository.save(driver);
        return "Success";
    }

    @Override
    public String updateDriver(Driver driver) {
        driverRepository.save(driver);
        return "Successfully Updated";
    }

    @Override
    public String deleteDriver(String Id) {
        driverRepository.deleteById(Id);
        return "Successfully Deleted";
    }

    @Override
    public Driver getDriver(String Id) {
        if (driverRepository.findById(Id).isEmpty())
            throw new DriverNotFoundException("The Requested Driver does not exist");
        return driverRepository.findById(Id).get();

    }


    @Override
    public List<Driver> getAllDrivers() {

        return driverRepository.findAll();
    }
@Override
    public List<Driver> getByFirstName(String firstName){
        return driverRepository.findByFirstName(firstName);
}
    }

