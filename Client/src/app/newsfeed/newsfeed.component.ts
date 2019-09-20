import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { Activity } from '../models/Activity';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.css']
})
export class NewsfeedComponent implements OnInit {

  user : User = new User();
  activities : Array<Activity> = [];
  constructor(
    private http : HttpClient
  ) { 
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.http.post("http://localhost:8082/PixoGramSpring/account/newsfeed", this.user)
      .subscribe((data: any) => {
        data.forEach(activity => {
          this.activities.push(activity);
        });
      }
      )
  }

  ngOnInit() {
    //this.user = JSON.parse(sessionStorage.getItem('user'));
    
  }

}
