package com.TransportDriver.driver.controller;

import com.TransportDriver.driver.model.Driver;
import com.TransportDriver.driver.response.ResponseHandler;
import com.TransportDriver.driver.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverAPIController
{
    DriverService driverService;
    public DriverAPIController(DriverService driverService) {
        this.driverService = driverService;
    }


//Read Specific Drivers details FROM DATABASE
@GetMapping("{Id}")
    public ResponseEntity<Object>  getDriverDetails(@PathVariable("Id") String Id)
      {
         return ResponseHandler.responseBuilder("Requested Driver Details are given here",
                  HttpStatus.OK, driverService.getDriver(Id));

                //("C1", "Mandy", "Khorommbi", "08738920", "mmkhoroombj@gamil.com", "787383282", "56THGP",
                //"5627", "3792", "Sibasa", "Limpopop", "2321");
    }
    //Read All Drivers details From DATABASE
    @GetMapping()
    public List<Driver> getAllDriverDetails() {
        return driverService.getAllDrivers();
    }
    //createRequest
    @PostMapping
    public String createDriverDetails(@RequestBody Driver driver)
    {
    driverService.createDriver(driver);
    return "Driver has been created Successfully";
    }
    //put is for updating
    @PutMapping
    public String updateDriverDetails(@RequestBody Driver driver)
    {
        driverService.updateDriver(driver);
        return "Driver has been updated Successfully!!";
    }
    @DeleteMapping("{Id}")
    public String deleteDriverDetails(@PathVariable("Id") String Id)
    {
        driverService.deleteDriver(Id);
        return "Driver has been deleted Successfully!!";
}
}