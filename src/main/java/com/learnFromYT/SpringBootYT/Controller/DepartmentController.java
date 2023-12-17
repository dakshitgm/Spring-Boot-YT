package com.learnFromYT.SpringBootYT.Controller;

import com.learnFromYT.SpringBootYT.entity.Department;
import com.learnFromYT.SpringBootYT.error.DepartmentNotFoundException;
import com.learnFromYT.SpringBootYT.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("inside save ");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getSingleDepartment(@PathVariable("id") long id) throws DepartmentNotFoundException{

        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable("id") long id){
        departmentService.deleteDepartment(id);
        return "department deleted Successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable  String name){
        return departmentService.getDepartmentByName(name);
    }

}
