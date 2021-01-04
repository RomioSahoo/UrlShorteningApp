package com.cognizant.hibernateTest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Salary {

	@Id
	private int empId;
	private int monthly_salary;
	private int annual_salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public long getMonthly_salary() {
		return monthly_salary;
	}

	public void setMonthly_salary(int monthly_salary) {
		this.monthly_salary = monthly_salary;
	}

	public long getAnnual_salary() {
		return annual_salary;
	}

	public void setAnnual_salary(int annual_salary) {
		this.annual_salary = annual_salary;
	}

}
