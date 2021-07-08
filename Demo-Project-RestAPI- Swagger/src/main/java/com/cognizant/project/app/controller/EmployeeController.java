package com.cognizant.project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.project.app.exception.EmployeeNotFoundException;
import com.cognizant.project.app.model.Employee;
import com.cognizant.project.app.service.EmployeeServiceI;

@RestController
@RequestMapping(value="employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceI employeeService;
	
	@PostMapping(value="/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee added",HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException{
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException{
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
	}

}
