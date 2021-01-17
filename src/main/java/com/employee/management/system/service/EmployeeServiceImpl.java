package com.employee.management.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee findById(long theId) {

		Employee theEmployee = null;
		Optional<Employee> theResult = employeeRepository.findById(theId);
		if (theResult.isPresent()) {

			theEmployee = theResult.get();
		} else {

			// we didn't find the Employee
			throw new RuntimeException("Can't find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

}
