package com.employeemanagement.backend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employeemanagement.backend.dto.RequestAcceptInDto;
import com.employeemanagement.backend.dto.RequestResourceInDto;
import com.employeemanagement.backend.dto.AllRequestOutDto;
import com.employeemanagement.backend.dto.OutDto;
import com.employeemanagement.backend.service.RequestResourceService;
import com.employeemanagement.backend.validator.RequestResourceValidator;

class RequestResourceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RequestResourceService requestResourceService;

    @Mock
    private RequestResourceValidator requestResourceValidator;

    @InjectMocks
    RequestResourceController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testAddReqestResourse() throws Exception {
        OutDto expectedResult = new OutDto();
        expectedResult.setMessage("Request added successfully");

        when(requestResourceService
                .addRequestService(any(RequestResourceInDto.class)))
                .thenReturn(expectedResult);

        // valid data.
        String json = "{\r\n"
                + "    \"managerEmail\": \"abhay@nucleusteq.com\",\r\n"
                + "    \"empId\": \"N0003\",\r\n" + "    \"projectId\": 2,\r\n"
                + "    \"comment\": \"Ashish kumar sahu\"\r\n" + "}";
        mockMvc.perform(post("/requestResource/addRequest")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value(expectedResult.getMessage()));

    }

    @Test
    void testAddReqestResourseWithInvalidEmailFormat() throws Exception {
        // invalid email format.
        String json = "{\r\n" + "    \"managerEmail\": \"abhay@gmail.com\",\r\n"
                + "    \"empId\": \"N0003\",\r\n" + "    \"projectId\": 2,\r\n"
                + "    \"comment\": \"Ashish kumar sahu\"\r\n" + "}";
        mockMvc.perform(post("/requestResource/addRequest")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testAddReqestResourseWithInvalidEmployeeId() throws Exception {
        // Invalid employee id.
        String json = "{\r\n"
                + "    \"managerEmail\": \"abhay@nucleusteq.com\",\r\n"
                + "    \"empId\": \"N54NM\",\r\n" + "    \"projectId\": 2,\r\n"
                + "    \"comment\": \"Ashish kumar sahu\"\r\n" + "}";
        mockMvc.perform(post("/requestResource/addRequest")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());

    }

    @Test
    void testAddReqestResourseWithEmptyProjectId() throws Exception {
        // project id empty.
        String json = "{\r\n"
                + "    \"managerEmail\": \"abhay@nucleusteq.com\",\r\n"
                + "    \"empId\": \"N0003\",\r\n" + "    \"projectId\": "
                + "    \"comment\": \"Ashish kumar sahu\"\r\n" + "}";
        mockMvc.perform(post("/requestResource/addRequest")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());

    }

    @Test
    void testCheckRequestResourseForEmployee() throws Exception {
        OutDto expectedResult = new OutDto();
        expectedResult.setMessage("True");

        when(requestResourceService
                .addRequestService(any(RequestResourceInDto.class)))
                .thenReturn(expectedResult);

        String json = "{\r\n"
                + "     \"managerEmail\": \"ashish.sahu@nucleusteq.com\",\r\n"
                + "    \"empId\": \"N0003\"\r\n" + "}";

        mockMvc.perform(post("/requestResource/checkRequestResource")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllRequests() throws Exception {
        List<AllRequestOutDto> expectedResult = new ArrayList<>();
        AllRequestOutDto request1 = new AllRequestOutDto();
        request1.setEmpName("Ashish");
        request1.setEmployeeId(1L);
        expectedResult.add(request1);

        when(requestResourceService.getAllRequests())
                .thenReturn(expectedResult);

        mockMvc.perform(get("/requestResource/getAllRequestResource"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(expectedResult.size()));
    }

    @Test
    void testDeleteRequest() throws Exception {
        OutDto expectedResult = new OutDto();
        expectedResult.setMessage("Deleted successfully");

        when(requestResourceService.deleteRequest(1L))
                .thenReturn(expectedResult);

        mockMvc.perform(delete("/requestResource/deleteRequest/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(expectedResult))
                .andExpect(jsonPath("$.message")
                        .value(expectedResult.getMessage()));
    }

    @Test
    void testAcceptRequest() throws Exception {
        OutDto expectedResult = new OutDto();
        expectedResult.setMessage("Accepted successfully");

        when(requestResourceService
                .acceptRequest(any(RequestAcceptInDto.class)))
                .thenReturn(expectedResult);

        String json = "{\r\n" + "    \"projectId\": 4,\r\n"
                + "    \"managerId\": 2,\r\n" + "    \"employeeId\": 17\r\n"
                + "}";
        mockMvc.perform(post("/requestResource/acceptRequest")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andExpect(jsonPath("$.message")
                        .value(expectedResult.getMessage()));
    }

}
