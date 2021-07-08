package com.cognizant.project.app.service;

import java.util.List;

import com.cognizant.project.app.exception.EmployeeNotFoundException;
import com.cognizant.project.app.model.Employee;

public interface EmployeeServiceI {
	
	//C-create
	public Employee addEmployee(Employee employee);

	//R-read
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException;
	
	//U-update
	public Employee updateEmployee(Employee employee)throws EmployeeNotFoundException;
	
	//D-delete
	public void deleteEmployee(int id)throws EmployeeNotFoundException;
}
