import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:String;
  password:String;
  inValid : boolean;

  constructor(
    private router:Router
  ) { }

  ngOnInit() {
  }

  login(){
    if(this.username==='kiran' && this.password==='dummy')
    {
    this.router.navigate(['employees']);
    }
    else{
      this.inValid =true;
    }
  }

}
