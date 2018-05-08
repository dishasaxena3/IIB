package com.ibm.service;

import java.util.List;

import com.ibm.model.Employee;

public interface EmployeeService {
	
	public Employee findById(long id);
	
	public Employee findByName(String name);
	
	public void saveEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployeeById(long id);

	public List<Employee> findAllEmployees();
	
	public void deleteAllEmployees();
	
	public boolean isEmployeeExist(Employee employee);


}
