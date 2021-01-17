package com.employee.management.system.service;

import java.util.List;

import com.employee.management.system.entity.Employee;

public interface EmployeeService {

	public Employee findById(long theId);

	public Employee save(Employee theEmployee);

	public List<Employee> findAll();


}
