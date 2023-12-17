package com.learnFromYT.SpringBootYT.repository;

import com.learnFromYT.SpringBootYT.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setup(){
        Department department = Department.builder()
                .departmentName("Other")
                .departmentAddress("something")
                .departmentCode("1103")
                .departmentId(1L)
                .build();

        department = testEntityManager.merge(department);

        testEntityManager.persist(department);
    }

    @Test
    public void  findByIdThenReturnDepartment(){
        Department found = departmentRepository.findById(1L).get();
        assertEquals(found.getDepartmentName(), "Other" );
    }

}