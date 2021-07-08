package com.cognizant.project.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.project.app.model.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer > {

}
