import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { User } from '../models/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public userModel : User = new User();
  public title = 'PixoGram - Login';
  public message : String;
  constructor(
    private authService : AuthService,
    private router : Router
  ) { 
    
  }
  ngOnInit(
    
  ) {
    
  }
  private status : boolean;
  onLogin(){
    this.status = this.authService.login(this.userModel);
    if(this.status){
      console.log("here")
      this.message="Login Successfull";
      
    }
    else{
      console.log("here2")
      this.message = "Login Failed";
    }
  }
}
