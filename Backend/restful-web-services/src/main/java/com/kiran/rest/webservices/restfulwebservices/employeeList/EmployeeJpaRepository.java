package com.kiran.rest.webservices.restfulwebservices.employeeList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employees,Long> {
	

}
