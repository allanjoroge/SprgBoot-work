package com.galaxe.demo.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl {

	@Autowired
	private EmployeeRepo emRepo;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = (List<Employee>) emRepo.findAll();
		if (employees.size() > 0) {
			return employees;
		} else {
			return new ArrayList<Employee>();
		}
	}

	public void createEmployee(Employee employee) {
		emRepo.save(employee);
	}

	public void deleteEmployee(Employee employee) {
		emRepo.deleteById(employee.getId());
	}

	public void updateEmployee(Employee employee) {
		Optional<Employee> employeeOptional = emRepo.findById(employee.getId());
		if (employeeOptional.isPresent()) {
			Employee emp = new Employee();
			emp.setId(employee.getId());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());

			emp = emRepo.save(emp);
		} else {
			emRepo.save(employee);
		}
	}
}
