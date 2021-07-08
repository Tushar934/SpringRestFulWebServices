package com.cognizant.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.project.app.dao.EmployeeDao;
import com.cognizant.project.app.exception.EmployeeNotFoundException;
import com.cognizant.project.app.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
	 @Autowired
	EmployeeDao employeeDao;
	 
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {

		Optional<Employee> employee=employeeDao.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new EmployeeNotFoundException();
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> emp=employeeDao.findById(employee.getId());
		if(emp.isPresent()) {
			employeeDao.save(employee);
		}
		throw new EmployeeNotFoundException();
	}

	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {

		Optional<Employee> emp=employeeDao.findById(id);
		if(emp.isPresent()) {
			employeeDao.delete(emp.get());
		}
		else {
			throw new EmployeeNotFoundException();
		}
	}
}
