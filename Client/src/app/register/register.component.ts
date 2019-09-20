import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router"

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public userModel : User = new User();
  public imagePath;
  imgURL: any;
  constructor(
    private http: HttpClient,
    private router : Router
    ) { }
    public checkMessage : string;
    public success : boolean;
    public registerMessage : String;
    public message : String;
    public available : boolean;
  ngOnInit() {
  }
  preview(files) {
    if (files.length === 0)
      return;
 
    var mimeType = files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = "Only images are supported.";
      return;
    }
 
    var reader = new FileReader();
    this.imagePath = files;
    reader.readAsDataURL(files[0]); 
    reader.onload = (_event) => { 
      this.imgURL = reader.result; 
    }
    
  }

  register(){
   /* this.userModel.profilePicture = this.imagePath;
    console.log(this.imagePath)*/
    this.http.post("http://localhost:8082/PixoGramSpring/account/register",this.userModel)
    .subscribe((data : any) =>{
      this.registerMessage = "Registered Successfully";
      this.success = true;
    },
    error => {
      this.registerMessage = "Registration was unsuccessful";
      this.success = false;
    }
    )
  }

  check(){
    this.http.post("http://localhost:8082/PixoGramSpring/account/check",this.userModel.username)
    .subscribe((data : User) =>{
      if(data != null){
        this.checkMessage = "User Name is already taken";
        this.available = false;
      }
      else{
        this.checkMessage = "User Name is available";
        this.available = true;
      }
    })
  }

}
