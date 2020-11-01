package com.cognizant.hibernateTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hibernateTest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
