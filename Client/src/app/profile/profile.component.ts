import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Followers } from '../models/Followers';
import { Media } from '../models/Media';
import { Blocked } from '../models/Blocked';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  sub: any;
  user: User = new User();
  
  public medias : Array<Media> = [] ;
  constructor(
    private activatedRoute: ActivatedRoute,
    private http: HttpClient
  ) {

  }

  ngOnInit() {
    this.sub = this.activatedRoute.params.subscribe(params => {
      this.user.userId = +params['userId'];
      console.log(this.user.userId)
      this.http.post("http://localhost:8082/PixoGramSpring/account/getUser", this.user)
        .subscribe((res: User) => {
          this.user = res;
        }
        )
    })
    this.http.post("http://localhost:8082/PixoGramSpring/mymedia/getAll", this.user)
      .subscribe((data: any) => {
        data.forEach(media => {
          this.medias.push(media);
        });
      }
      )
    console.log(this.user);
  }
  public mainUser: User = JSON.parse(sessionStorage.getItem('user'));
  public follower: Followers = new Followers();
  public followMessage : string;
  public followStatus : boolean;
  follow(user: User) {
    this.follower.userId = this.mainUser.userId;
    this.follower.followerName = user.username;
    this.follower.followerId = user.userId;
    this.follower.followerPicture = user.profilePicture;
    this.follower.following = 'Y';
    this.http.post("http://localhost:8082/PixoGramSpring/follow/follow", this.follower)
      .subscribe((data: Followers) => {
        if(data != null){
          this.followMessage = "You are now following " + this.follower.followerName;
          this.followStatus = true;
        }
        else{
          this.followMessage = "There was an error following " + this.follower.followerName;
          this.followStatus = false;
        }
      })
  }
  public blocked : Blocked = new Blocked();
  public blockedMessage : string;
  public blockedStatus : boolean;
  block(user : User){
    this.blocked.userId = this.mainUser.userId;
    this.blocked.username = this.mainUser.username;
    this.blocked.blockedId = user.userId;
    this.blocked.blockedUser = user.username;
    this.http.post("http://localhost:8082/PixoGramSpring/blocked/block", this.blocked)
      .subscribe((data: Blocked) => {
        if(data != null){
          this.blockedMessage = "Blocked Successfully"
          this.blockedStatus = true;
        }
        else{
          this.blockedMessage = "The User was not blocked"
          this.blockedStatus = false;
        }
      })
  }

}
