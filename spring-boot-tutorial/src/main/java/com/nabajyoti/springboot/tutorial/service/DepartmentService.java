package com.nabajyoti.springboot.tutorial.service;


import java.util.List;

import com.nabajyoti.springboot.tutorial.entities.Department;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department findDepartment(Long departmentld);

    public Department fetchDepartmentByName(String departmentName);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);
    
}
