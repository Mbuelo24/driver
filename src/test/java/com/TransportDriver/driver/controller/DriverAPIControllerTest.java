package com.TransportDriver.driver.controller;

import com.TransportDriver.driver.model.Driver;
import com.TransportDriver.driver.service.DriverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DriverAPIController.class)
class DriverAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DriverService driverService;
    Driver driverOne;
    Driver driverTwo;
    List<Driver> driverList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        driverOne = new Driver("C1", "Mandy", "Khorommbi", "08738920", "mmkhoroombj@gamil.com", "787383282", "56THGP",
                "5627", "3792", "Sibasa", "Limpopop", "2321");
        driverTwo = new Driver("C2", "Mbuelo", "Khoro", "8920", "khoroombj@gamil.com", "383282", "6THGP",
                "5627", "3592", "SibasaM", "Limpo", "23321");
        driverList.add(driverOne);
        driverList.add(driverTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetDriverDetails() throws Exception {
     when(driverService.getDriver("C1"))
             .thenReturn(driverOne);
     this.mockMvc.perform(get("/driver/C1"))
             .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testGetAllDriverDetails() throws Exception {
        when(driverService.getAllDrivers())
                .thenReturn(driverList);
        this.mockMvc.perform(get("/driver"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateDriverDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(driverOne);


        when(driverService.createDriver(driverOne))
                .thenReturn("Successfully Updated");
        this.mockMvc.perform(post("/driver")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateDriverDetails() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(driverOne);


        when(driverService.updateDriver(driverOne))
                .thenReturn("Successfully Updated");
        this.mockMvc.perform(put("/driver")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testDeleteDriverDetails() throws Exception{
        when(driverService.deleteDriver("C1"))
                .thenReturn("Successfully Deleted");
        this.mockMvc.perform(delete("/driver/C1"))
                .andDo(print()).andExpect(status().isOk());
    }
}