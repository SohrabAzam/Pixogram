import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit() {
  }
  public user: User = JSON.parse(sessionStorage.getItem('user'));
  public checkMessage: string;
  public message: string;
  public available : boolean;
  public success : boolean;
  check() {
    this.http.post("http://localhost:8082/PixoGramSpring/account/check", this.user.username)
      .subscribe((data: User) => {
        if (data != null) {
          this.checkMessage = "User Name is already taken";
          this.available = false;
        }
        else {
          this.checkMessage = "User Name is available";
          this.available = true;
        }
      })
  }

  update() {
    this.http.post("http://localhost:8082/PixoGramSpring/account/update", this.user)
      .subscribe((data: User) => {
        this.message = "Updated Successfully";
        this.success = true;
        sessionStorage.removeItem("user");
        sessionStorage.setItem("user",JSON.stringify(data));
      },
        error => {
          this.message = "Failed to Update. Check Details";
          this.success = false;
        }
      )
  }
}
