package com.ihamza.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ihamza.domain.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	List<Employee> findTop3ByOrderByIdDesc();

}
