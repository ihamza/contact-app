package com.ihamza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihamza.domain.Employee;
import com.ihamza.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee get(Long id){
		return repository.findOne(id);
	}
	
	public Iterable<Employee> getAll()
	{
		return repository.findAll();

	}
	
	public Long create(Employee employee){
		
		//TODO handle Exceptions
		Employee e = repository.save(employee);
		return e.getId();		
		
	}
	
	public Long update(Long id,Employee employee){
		Employee oldEmployee = repository.findOne(id);
		// check existing employee 
		if (oldEmployee ==null ) {
			throw new RuntimeException("Employee does not exist");
		}
		//compare to passed ids 
		if (employee==null || employee.getId() == null || employee.getId() != id)
		{
			throw new RuntimeException("Employee ids mismatch");
		}
		
		Employee newEmployee =  repository.save(employee);				
		return newEmployee.getId();		
	}
	
	public void delete (Long id){
		repository.delete(id);
	}
}

