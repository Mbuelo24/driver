package com.TransportDriver.driver.service.impl;

import com.TransportDriver.driver.model.Driver;
import com.TransportDriver.driver.repository.DriverRepository;
import com.TransportDriver.driver.service.DriverService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DriverServiceImplTest {

    @Mock
    private DriverRepository driverRepository;
    private DriverService driverService;
    AutoCloseable autoCloseable;
    Driver driver;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        driverService = new DriverServiceImpl(driverRepository);
        driver = new Driver("C1", "Mandy", "Khorommbi", "08738920", "mmkhoroombj@gamil.com", "787383282", "56THGP",
                "5627", "3792", "Sibasa", "Limpopop", "2321");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
    @Test
    void testcreateDriver(){
        mock(Driver.class);
        mock(DriverRepository.class);

        when(driverRepository.save(driver)).thenReturn(driver);
        assertThat(driverService.createDriver(driver)).isEqualTo("Success");

    }
    @Test
    void testUpdateDriver(){
        mock(Driver.class);
        mock(DriverRepository.class);

        when(driverRepository.save(driver)).thenReturn(driver);
        assertThat(driverService.updateDriver(driver)).isEqualTo("Successfully Updated");
    }

    @Test
    void testGetDriver(){
        mock(Driver.class);
        mock(DriverRepository.class);

        when(driverRepository.findById("1")).thenReturn(Optional.ofNullable(driver));
        assertThat(driverService.getDriver("1").getFirstName())
                .isEqualTo(driver.getFirstName());
    }
    @Test
    void testGetByFirstName(){
        mock(Driver.class);
        mock(DriverRepository.class);

        when(driverRepository.findByFirstName("Mandy")).thenReturn(
                new ArrayList<Driver>(Collections.singletonList(driver))
        );
        assertThat(driverService.getByFirstName("Mandy").get(0).getId())
                .isEqualTo(driver.getId());

    }

    @Test
    void testGetAllDrivers(){
        mock(Driver.class);
        mock(DriverRepository.class);

        when(driverRepository.findAll()).thenReturn(
                new ArrayList<Driver>(Collections.singletonList(driver))
        );
        assertThat(driverService.getAllDrivers().get(0).getContactNumber())
                .isEqualTo(driver.getContactNumber());
    }
    @Test
    void testDeleteDriver(){
        mock(Driver.class);
        mock(DriverRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(
                driverRepository).deleteById(any());

        assertThat(driverService.deleteDriver("1")).isEqualTo("Successfully Deleted");

    }
}