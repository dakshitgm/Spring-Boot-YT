package com.learnFromYT.SpringBootYT.repository;

import com.learnFromYT.SpringBootYT.entity.Department;
import org.hibernate.annotations.SQLSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String name);

    @Query(value = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME = :departmentName", nativeQuery = true)
    public List<Department> getName(@Param("departmentName") String name);
}
