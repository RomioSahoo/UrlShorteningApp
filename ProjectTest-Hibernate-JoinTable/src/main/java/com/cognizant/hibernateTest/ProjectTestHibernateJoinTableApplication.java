package com.cognizant.hibernateTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.hibernateTest.dao.EmployeeDao;

@SpringBootApplication
public class ProjectTestHibernateJoinTableApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(ProjectTestHibernateJoinTableApplication.class, args);
		EmployeeDao dao=(EmployeeDao)ctx.getBean(EmployeeDao.class);
		
		dao.findAll().forEach(employee->{
			System.out.println(employee.getEmpId());
			System.out.println(employee.getFirstName()+" "+employee.getLastName());
//			System.out.println(employee.getLastName());
			System.out.println(employee.getSkill());
			System.out.println(employee.getSalary().getMonthly_salary());
			System.out.println(employee.getSalary().getAnnual_salary());
			
			System.out.println("------------------------------------");
		});
	}

}
