import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from "@angular/common/http";
import { Media } from '../models/Media';

@Component({
  selector: 'app-my-media',
  templateUrl: './my-media.component.html',
  styleUrls: ['./my-media.component.css']
})
export class MyMediaComponent implements OnInit {
  public user : User;
  public medias : Array<Media> = [] ;
  constructor(
    private http: HttpClient
  ) { 
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.http.post("http://localhost:8082/PixoGramSpring/mymedia/getAll", this.user)
      .subscribe((data: any) => {
        data.forEach(media => {
          console.log(media);
          this.medias.push(media);
        });
      }
      )
  }

  ngOnInit() {
   

  }

}
