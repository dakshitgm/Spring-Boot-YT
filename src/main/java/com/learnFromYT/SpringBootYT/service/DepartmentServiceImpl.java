package com.learnFromYT.SpringBootYT.service;

import com.learnFromYT.SpringBootYT.entity.Department;
import com.learnFromYT.SpringBootYT.error.DepartmentNotFoundException;
import com.learnFromYT.SpringBootYT.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(long id) throws DepartmentNotFoundException {

        Optional<Department> department =  departmentRepository.findById(id);

        if(!department.isPresent()) throw new DepartmentNotFoundException("Department Not available");

        return department.get();
    }

    @Override
    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department body){
        Department department = departmentRepository.findById(id).get();

        if(Objects.nonNull(body.getDepartmentName()) && !"".equals(body.getDepartmentName()))
            department.setDepartmentName(body.getDepartmentName());

        if(Objects.nonNull(body.getDepartmentAddress()) && !"".equals(body.getDepartmentAddress()))
            department.setDepartmentAddress(body.getDepartmentAddress());

        if(Objects.nonNull(body.getDepartmentCode()))
            department.setDepartmentCode(body.getDepartmentCode());

        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentByName(String name){
        return departmentRepository.getName(name).get(0);
    }
}
