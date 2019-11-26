package com.kiran.rest.webservices.restfulwebservices.employeeList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeHardCodedService {
	
	private static List<Employees> emp = new ArrayList<>();
	private static long idCounter=0;
	
	static{
		emp.add(new Employees(++idCounter,"Kiran","DM","Male",new Date(),"CSE"));
		emp.add(new Employees(++idCounter,"Praveen","DM","Male",new Date(),"EC"));
		emp.add(new Employees(++idCounter,"Pooja","K","Female",new Date(),"Maths"));
		emp.add(new Employees(++idCounter,"Ashwin","B","Male",new Date(),"Maths"));
		emp.add(new Employees(++idCounter,"Amit","B","Male",new Date(),"Maths"));
	}
	
	public List<Employees> findAll(){
		return emp;
	}
	
	
	public Employees save(Employees employee)
	{
		if(employee.getId()==-1|| employee.getId()==0)
		{
			employee.setId(++idCounter);
			emp.add(employee);
		}
		else{
			deleteByID(employee.getId());
			emp.add(employee);
		}
		return employee;
	}
	
	
	public Employees deleteByID(long id){
		Employees employee = findbyID(id);
		if(employee == null)
		{
			return null;
		}
		//if(((List<Employees>) emp).remove(emp))
		if(emp.remove(employee))
		{
			return employee;
		}
		return null;
	    
	}

	public Employees findbyID(long id) {
		// TODO Auto-generated method stub
		for(Employees emp:emp)
		{
			if(emp.getId()==id)
			{
				return emp;
			}
		}
		return null;
	}
	
	

}
