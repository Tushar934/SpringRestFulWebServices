package com.cognizant.project.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Can't find the employee")
public class EmployeeNotFoundException extends Exception{

}
