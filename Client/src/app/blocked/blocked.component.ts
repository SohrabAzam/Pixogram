import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';
import { Blocked } from '../models/Blocked';

@Component({
  selector: 'app-blocked',
  templateUrl: './blocked.component.html',
  styleUrls: ['./blocked.component.css']
})
export class BlockedComponent implements OnInit {

  public user : User;
  public blockedUsers : Array<Blocked> = [];
  constructor(
    private http: HttpClient
  ) { 
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.http.post("http://localhost:8082/PixoGramSpring/blocked/all", this.user)
      .subscribe((data: any) => {
        data.forEach(blockedUser => {
          this.blockedUsers.push(blockedUser);
        });
      }
      )
  }

  ngOnInit() {
  }

  unblock(blockedUser : Blocked){
    this.http.post("http://localhost:8082/PixoGramSpring/blocked/unblock", blockedUser)
      .subscribe((data: Blocked) => {
        console.log(data);
      })
  }

}
