package com.ibm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibm.model.Employee;

@RepositoryRestResource
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
