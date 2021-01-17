package com.employee.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.exceptions.EmployeeNotFoundException;
import com.employee.management.system.service.EmployeeService;
import com.employee.management.system.util.StateEnums;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService theEmployeeService;

	public EmployeeController(EmployeeService theEmployeeService) {

		this.theEmployeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public List<Employee> retrieveAllemployees() {
		return theEmployeeService.findAll();
	}

	@ApiOperation(value = "Create New employee", response = Employee.class, tags = { "createEmployee" })
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 200, message = "Added Successfully") })
	@PostMapping("/employees/add")
	public Employee createEmployee(@RequestBody Employee employee) {

		employee.setState(StateEnums.ADDED);
		return theEmployeeService.save(employee);
	}

	// updateUser
	@ApiOperation(value = "Update user object by Id", response = Employee.class, tags = { "UpdateEmployee" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 404, message = "not found") })

	@PutMapping("/employees/{theId}")
	public Employee updateEmployee(@RequestBody Employee theEmployee, @PathVariable long theId) {

		Employee returnedEmployee = theEmployeeService.findById(theId);

		if (returnedEmployee == null)
			throw new EmployeeNotFoundException("Employee Not Found");

		theEmployee.setId(theId);

		return theEmployeeService.save(theEmployee);
	}

}
