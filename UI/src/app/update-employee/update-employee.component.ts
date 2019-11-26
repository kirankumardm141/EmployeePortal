import { Component, OnInit } from '@angular/core';
import { EmployeesDataService } from '../service/data/employees-data.service';
import { Employee } from '../employees/employees.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id:number;
  employee:Employee;

  constructor(
    private employeeService:EmployeesDataService,
    private route:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit() {
    this.id= this.route.snapshot.params['id'];
    this.employee = new Employee(this.id,'','','','','');
    if(this.id!=-1)
    {
     this.employeeService.retrieveEmployees(this.id).subscribe(
       data => this.employee=data
     )
    }
    }

  saveEmployee(){
    if(this.id===-1){
      this.employeeService.createEmployees(this.employee).subscribe(
        data =>{
          console.log(data)
          this.router.navigate(['employees'])
        }
       )

    }
    else{
    this.employeeService.updateEmployees(this.id,this.employee).subscribe(
     data =>{
       console.log(data)
       this.router.navigate(['employees'])
     }
    )
  }
  }
}
