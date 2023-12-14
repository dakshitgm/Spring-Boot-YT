package com.learnFromYT.SpringBootYT.service;

import com.learnFromYT.SpringBootYT.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {

    public Department saveDepartment(Department department);
    public List<Department> getDepartments();
    public Department getDepartment(long id);
    public void deleteDepartment(long id);
    public Department updateDepartment(Long id, Department body);
    public Department getDepartmentByName(String name);
}
