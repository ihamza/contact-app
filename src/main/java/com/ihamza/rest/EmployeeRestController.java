package com.ihamza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@ApiOperation(value = "create Employee", notes = "Create New Employee", response = Long.class, tags = {
	"RestController" })
	public ResponseEntity<?> create(@RequestBody Employee employee){
		Long createdid =   service.create(employee);		
		return new ResponseEntity<Long>(createdid, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}",name="get Employee by id" ,method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "get Employee by id",	notes = "<br/>To retrieve employee by id <br/> for example <BaseURL>/v1.0/employee/1 <br/>",	
	response = Employee.class, tags = { "RestController", })
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Employee employee = service.get(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);		
	}
	
	@RequestMapping(path = "/",name="get All Employee" ,method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "get Employee by id",	notes = "<br/>To retrieve all employees ",	
	response = Employee.class,responseContainer = "List" ,tags = { "RestController", })	

	public ResponseEntity<?> getAll(){
		Iterable<Employee> employees = service.getAll();
		return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}" ,method = RequestMethod.PUT)
	@ApiOperation(value = "update Employee", notes = "update existing Employee", response = Long.class, tags = {
	"RestController" })
	public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody Employee employee){
		Long updatedid =   service.update(id, employee);		
		return new ResponseEntity<Long>(updatedid, HttpStatus.OK);
	}	

	@RequestMapping(path = "/{id}" ,method = RequestMethod.DELETE)
	@ApiOperation(value = "delete Employee", notes = "delete Employee by id", response = Void.class, tags = {
	"RestController" })
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		  service.delete(id);		
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
