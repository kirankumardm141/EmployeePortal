package com.kiran.rest.webservices.restfulwebservices.employeeList;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeJpaList {
	
	
	@Autowired
	 private EmployeeHardCodedService employeeService;
	
	@Autowired
	 private EmployeeJpaRepository employeeJpaRepository;
	
//	@GetMapping("/users/{username}/Employees")
//     public List<Employees> getAllEmployees(@PathVariable String UserName)
//     {
//    	 return employeeService.findAll();
//     }
	
	@GetMapping("/jpa/users/Employees")
    public List<Employees> getAllEmployees()
    {
		return employeeJpaRepository.findAll();
   	 	//return employeeService.findAll();
    }
	
	@GetMapping("/jpa/users/Employees/{id}")
    public Employees getEmployee(@PathVariable long id)
    {
	 return employeeJpaRepository.findById(id).get();
   	 //return employeeService.findbyID(id);
    }
	
	
	
	@DeleteMapping("/jpa/users/Employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long id)
	{
		//Employees emp = employeeService.deleteByID(id);
		employeeJpaRepository.deleteById(id);
//		if(emp != null)
//		{
			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/jpa/users/Employees/{id}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable long id,
			@RequestBody Employees employee){
		Employees empupdated = employeeJpaRepository.save(employee);
		return new ResponseEntity<Employees>(employee,HttpStatus.OK); 
	}
	
	@PostMapping("/jpa/users/Employees")
	public ResponseEntity<Void> addEmployee(@PathVariable long id,
			@RequestBody Employees employee){
		Employees createdemp = employeeJpaRepository.save(employee);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdemp.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
}
