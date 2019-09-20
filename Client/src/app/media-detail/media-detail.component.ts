import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { ActivatedRoute } from '@angular/router';
import { Media } from '../models/Media';
import { HttpClient } from '@angular/common/http';
import { Comment } from '../models/Comment';
import { Like } from '../models/Like';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
@Component({
  selector: 'app-media-detail',
  templateUrl: './media-detail.component.html',
  styleUrls: ['./media-detail.component.css']
})
export class MediaDetailComponent implements OnInit {
  sub: any;
  user: User;
  media: Media = new Media();
  comments: Array<Comment> = [];
  newComment: Comment = new Comment();
  message: string;
  likeMessage: string;
  likeObj: Like = new Like();
  constructor(
    public activatedRoute: ActivatedRoute,
    public http: HttpClient,
    public router : Router,
    private location : Location
  ) {
    this.user = JSON.parse(sessionStorage.getItem('user'));

  }

  ngOnInit() {
    console.log("entered")
    this.sub = this.activatedRoute.params.subscribe(params => {
      console.log("inside")
      this.media.mediaId = +params['mediaId'];
      console.log(this.media.mediaId)
      this.http.post("http://localhost:8082/PixoGramSpring/media/getMedia", this.media)
        .subscribe((res: Media) => {
          this.media = res;
          console.log(this.media);
        }
        )
      this.http.post("http://localhost:8082/PixoGramSpring/media/getComments", this.media)
        .subscribe((res: any) => {
          res.forEach(comment => {
            this.comments.push(comment);
          });
        }
        )
    })
  }

  postComment() {
    this.newComment.mediaId = this.media.mediaId;
    this.newComment.userId = this.media.userId;
    this.newComment.commentorId = this.user.userId;
    this.newComment.commentorName = this.user.username;
    this.http.post("http://localhost:8082/PixoGramSpring/media/saveComment", this.newComment)
      .subscribe((res: Comment) => {
        if (res != null) {
          this.message = "Comment Posted Successfully";
        }
        console.log(res);
      }
      )
      window.location.reload();
  }

  like(val: string) {
    console.log(val)
    if (val == 'Y') {
      this.likeObj.like = 'Y';
    }
    else {
      this.likeObj.like = 'N';
    }
    this.likeObj.likerId = this.user.userId;
    this.likeObj.likerName = this.user.username;
    this.likeObj.mediaId = this.media.mediaId;
    this.likeObj.userId = this.media.userId;
    this.http.post("http://localhost:8082/PixoGramSpring/media/like", this.likeObj)
      .subscribe((res: Comment) => {
        if (res != null) {
          if (val == 'Y') {
            this.likeMessage = 'Liked';
          }
          else {
            this.likeMessage = 'Disliked';
          }
        }
        console.log(res);
      }
      )
      window.location.reload();
  }

  // dislike() {
  //   this.likeObj.likerId = this.user.userId;
  //   this.likeObj.likerName = this.user.username;
  //   this.likeObj.mediaId = this.media.id;
  //   this.likeObj.userId = this.media.userId;
  //   this.likeObj.like = 'N';
  //   this.http.post("http://localhost:8080/PixoGramSpring/media/like", this.likeObj)
  //     .subscribe((res: Comment) => {
  //       if (res != null) {
  // if (val == 'Y') {
  //   this.likeMessage = 'Liked';
  // }
  // else {
  //   this.likeMessage = 'Disliked';
  // }
  //       }
  //       console.log(res);
  //     }
  //     )
  // }
}
