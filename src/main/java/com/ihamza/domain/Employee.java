package com.ihamza.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
    private String name;
    private String email;
    private String phone;
    private Date hireDate;
    private BigDecimal salary;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
    
    
}
