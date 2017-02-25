package com.ihamza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihamza.domain.Employee;
import com.ihamza.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1.0/viewemployee", produces = "application/json")
public class EmployeeViewRestController {

	@Autowired
	EmployeeService service;

	@RequestMapping(path = "/", name = "get Employee Contacts", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "get  Employee contacts", notes = "<br/>To retrieve all employees ", response = Employee.class, responseContainer = "List", tags = {
			"Client", })
	public ResponseEntity<?> getContacts() {
		Iterable<Employee> employees = service.getViewedAll();
		return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	}

}
