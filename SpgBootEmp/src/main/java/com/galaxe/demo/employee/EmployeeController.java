package com.galaxe.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeImpl emImpl;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return emImpl.getAllEmployees();
	}
	
	@GetMapping("/addEmployee") @PostMapping("/addEmployee")
	public void addEmployee(Employee employee) {
		employee.setFirstName("Allan");
		employee.setLastName("Njoroge");
		employee.setUsername("anjoroge");
		employee.setPassword("galaxy123");
		emImpl.createEmployee(employee);
	}
	
	@GetMapping("/deleteEmployee")
	public void deleteEmployee(Employee employee) {
		employee = emImpl.getAllEmployees().get(0);
		emImpl.deleteEmployee(employee);
	}
	
	@GetMapping("/editEmployee") @PostMapping("/editEmployee")
	public void editEmployee(Employee employee) {
		emImpl.updateEmployee(employee);
	}
}
