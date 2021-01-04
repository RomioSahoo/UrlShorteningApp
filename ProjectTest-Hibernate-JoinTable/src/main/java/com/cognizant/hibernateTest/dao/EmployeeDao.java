package com.cognizant.hibernateTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hibernateTest.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{

}
