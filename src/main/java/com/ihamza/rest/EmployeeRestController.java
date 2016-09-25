package com.ihamza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihamza.domain.Employee;
import com.ihamza.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1.0/employee", produces = "application/json")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(path = "/" ,method = RequestMethod.POST)
	public ResponseEntity<?> create(Employee employee){
		Long createdid =   service.create(employee);		
		return new ResponseEntity<Long>(createdid, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}",name="get Employee by id" ,method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "get Employee by id",	notes = "<br/>To retrieve employee by id code enter <br/> for example <BaseURL>/v1.0/employee/1 <br/>",	response = Employee.class, tags = { "RestController", })
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Employee employee = service.get(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);		
	}
	
	@RequestMapping(path = "/",name="get All Employee" ,method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAll(){
		Iterable<Employee> employees = service.getAll();
		return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<?> update(Long id,Employee employee){
		Long updatedid =   service.update(id, employee);		
		return new ResponseEntity<Long>(updatedid, HttpStatus.OK);
	}	

	@RequestMapping(path = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(Long id){
		  service.delete(id);		
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
