import { Component, OnInit } from '@angular/core';
import { EmployeesDataService } from '../service/data/employees-data.service';
import { Router } from '@angular/router';
import {MatSortModule} from '@angular/material/sort';


export class Employee{
  
  constructor(public id:number,
              public firstName :String,
              public lastName:String,
              public gender:String,
              public dob:String,
              public department:String
) { }

}

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})


export class EmployeesComponent implements OnInit {

employees :Employee[];
message :String;

  constructor(
    private service: EmployeesDataService,
    private router:Router) { }


  ngOnInit() {
    this.ListofEmployees();
  }

  ListofEmployees() {
   // console.log(this.service.executeHelloWorldBeanService());
    this.service.retrieveAllEmployees().subscribe(
      response => {
        this.employees =response;
      }
    );
  }

  deleteEmployee(id){
    console.log(`delete Employee ${id}`)
    this.service.deleteEmployees(id).subscribe(
      response => {
      console.log(response)
      this.message = `Delete Employee ${id} Successful !`
      this.ListofEmployees();
      }
    )
  }
  // handleSuccessfulResponse(response) {
  //     console.log(response.message);

  // }

  updateEmployee(id){
    console.log(`Update Employee ${id}`);
    this.router.navigate(['employees', id]);
    //this.router.navigate(['/updateEmployee']);
  }


  addEmployee(){
    this.router.navigate(['employees',-1]);
  }


}
