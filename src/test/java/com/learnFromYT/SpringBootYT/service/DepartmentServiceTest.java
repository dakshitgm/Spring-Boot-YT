package com.learnFromYT.SpringBootYT.service;

import com.learnFromYT.SpringBootYT.entity.Department;
import com.learnFromYT.SpringBootYT.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeAll
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("something")
                .departmentCode("1103")
                .departmentId(45)
                .build();

        List<Department> list = new LinkedList<>();
        list.add(department);

        Mockito.when(departmentRepository.getName("IT")).thenReturn(list);
    }

    @Test
    @DisplayName("Get data by valid name")
    public void whenValidDepartmentNameThenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}