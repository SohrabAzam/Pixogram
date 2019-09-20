import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from "@angular/common/http";
import { Router } from '@angular/router';
import { Followers } from '../models/Followers';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  public user : User;
  public searchText : string;
  public users: Array<User> = [];
  constructor(
    private http : HttpClient,
    private router : Router
  ) {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.http.get("http://localhost:8082/PixoGramSpring/account/fetchUsers")
    .subscribe((data : any) =>
    {
      data.forEach(user => {
        this.users.push(user);
      });
    }
    )
   }

  ngOnInit() {
    
  }
  public follower : Followers = new Followers();
  checkUser(user : User){
   if(user.username.match(this.searchText))
    return true;
  else
    return false;
  }
  search(){

  }

  /*loadUser(user : User){
    console.log(user.username);
    this.router.navigateByUrl("/dashboard/"+user.username);
  }*/

  follow(user : User){
    this.follower.userId = this.user.userId;
    this.follower.followerName = user.username;
    this.follower.followerId = user.userId;
    this.follower.followerPicture = user.profilePicture;
    this.follower.following = 'Y';
    this.http.post("http://localhost:8082/PixoGramSpring/follow/follow",this.follower)
    .subscribe((data : Followers) =>
      {
        console.log(data);
      })
  }

  compare(user : User){
    if(user.userId == this.user.userId){
      return false;
    }
    else{
      return true;
    }
  }
}
