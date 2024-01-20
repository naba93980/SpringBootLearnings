package com.nabajyoti.springboot.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nabajyoti.springboot.tutorial.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    public Department findByDepartmentName(String departmentName);

}
