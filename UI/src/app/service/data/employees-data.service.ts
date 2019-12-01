import { Injectable } from '@angular/core';
import { HttpClient }  from '@angular/common/http';
import { Employee } from 'src/app/employees/employees.component';

@Injectable({
  providedIn: 'root'
})
export class EmployeesDataService {

  constructor(
    private http:HttpClient
  ) { }

  // executeHelloWorldBeanService(){
  //   //console.log('Execute Hello World Bean Service');
  //   return this.http.get<HelloWorldBean>('http://localhost:8080/hello-world-bean');
  // }

  retrieveAllEmployees(){
    return this.http.get<Employee[]>('http://localhost:8080/jpa/users/Employees');
  }

  deleteEmployees(id){
    return this.http.delete(`http://localhost:8080/jpa/users/Employees/${id}`);
  }

  retrieveEmployees(id){
    return this.http.get<Employee>(`http://localhost:8080/jpa/users/Employees/${id}`);
  }

  updateEmployees(id,employees){
    //console.log(id,employees);
    return this.http.put(`http://localhost:8080/jpa/users/Employees/${id}`,employees);
  }

  createEmployees(employees){
    return this.http.post(`http://localhost:8080/jpa/users/Employees`,employees);
  }
}
