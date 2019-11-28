import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeesComponent } from './employees/employees.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path: '',component:LoginComponent},
  { path: 'employees',component:EmployeesComponent},
  { path: 'employees/:id',component:UpdateEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
