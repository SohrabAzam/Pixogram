import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';
import { Followers } from '../models/Followers';


@Component({
  selector: 'app-followers',
  templateUrl: './followers.component.html',
  styleUrls: ['./followers.component.css']
})
export class FollowersComponent implements OnInit {
  public user: User;
  public followers: Array<Followers> = [];
  constructor(
    private http: HttpClient
  ) {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.http.post("http://localhost:8082/PixoGramSpring/follow/all", this.user)
      .subscribe((data: any) => {
        data.forEach(follower => {
          this.followers.push(follower);
        });
      }
      )
  }
  ngOnInit() {
  }
  isFollowing(follower: Followers) {
    if (follower.following == 'Y') {
      return true;
    }
    else {
      return false;
    }
  }
  isFollower(follower: Followers) {
    if (follower.follower == 'Y') {
      return true;
    }
    else {
      return false;
    }
  }

  follow(follower: Followers) {
    follower.following = 'Y';
    this.http.post("http://localhost:8082/PixoGramSpring/follow/follow", follower)
      .subscribe((data: Followers) => {
        console.log(data);
      })
  }

  unfollow(follower: Followers) {
    follower.following = 'N';
    this.http.post("http://localhost:8082/PixoGramSpring/follow/unfollow", follower)
      .subscribe((data: Followers) => {
        console.log(data);
      })
  }



}
