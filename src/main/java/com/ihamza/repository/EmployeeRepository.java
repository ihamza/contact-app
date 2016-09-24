package com.ihamza.repository;

import org.springframework.data.repository.CrudRepository;

import com.ihamza.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
