package com.ibm.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ibm.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	private static final AtomicLong counter = new AtomicLong();
	private static List<Employee> employees;

	
	static{
		employees= populateDummyEmployees();
	}

	
	@Override
	public Employee findById(long id) {
		
		for(Employee employee : employees){
			if(employee.getId() == id){
				return employee;
			}
		}
		return null;

	}

	private static List<Employee> populateDummyEmployees() {
		System.out.println("Inside populatedummy Employees.........");
		List<Employee> users = new ArrayList<Employee>();
		users.add(new Employee(counter.incrementAndGet(),"Sam","Saxena"));
		users.add(new Employee(counter.incrementAndGet(),"Saurabh","Saxena"));
		users.add(new Employee(counter.incrementAndGet(),"Lily","Saxena"));
		return users;
	
	}

	@Override
	public Employee findByName(String name) {
		for(Employee employee : employees){
			if(employee.getFirstName().equalsIgnoreCase(name)){
				return employee;
			}
		}
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employee.setId(counter.incrementAndGet());
		employees.add(employee);

		
	}

	@Override
	public void updateEmployee(Employee employee) {
		int index = employees.indexOf(employee);
		employees.set(index, employee);

		
	}

	@Override
	public void deleteEmployeeById(long id) {
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
		    Employee employee = iterator.next();
		    if (employee.getId() == id) {
		        iterator.remove();
		    }
		}

		
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return employees;
	}

	@Override
	public void deleteAllEmployees() {
		employees.clear();
		
	}

	@Override
	public boolean isEmployeeExist(Employee employee) {
		return findByName(employee.getFirstName())!=null;

	}

	
}
