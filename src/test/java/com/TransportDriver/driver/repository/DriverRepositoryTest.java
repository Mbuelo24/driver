package com.TransportDriver.driver.repository;

import com.TransportDriver.driver.model.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DriverRepositoryTest {
    @Autowired
    private DriverRepository driverRepository;
    Driver driver;

    @BeforeEach
    void setUp() {
      driver = new Driver("C1", "Mandy", "Khorommbi", "08738920", "mmkhoroombj@gamil.com", "787383282", "56THGP",
              "5627", "3792", "Sibasa", "Limpopop", "2321");
      driverRepository.save(driver);
    }

    @AfterEach
    void tearDown() {
        driver = null;
        driverRepository.deleteAll();

    }
    //Test Success
    @Test
    void testFindByFirstName_FOUND()
    {
        List<Driver> driverList = driverRepository.findByFirstName("Mandy");
        assertThat(driverList.get(0).getId()).isEqualTo(driver.getId());
        assertThat(driverList.get(0).getProvince())
        .isEqualTo(driver.getProvince());
    }
    //Test Failed
    @Test
    void testFindByFirstName_NotFOUND()
    {
        List<Driver> driverList = driverRepository.findByFirstName("Rori");
        assertThat(driverList.isEmpty()).isTrue();
    }
}
