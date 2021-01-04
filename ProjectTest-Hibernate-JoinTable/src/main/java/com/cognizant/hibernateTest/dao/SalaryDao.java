package com.cognizant.hibernateTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hibernateTest.entity.Salary;

public interface SalaryDao extends JpaRepository<Salary,Integer> {

}
