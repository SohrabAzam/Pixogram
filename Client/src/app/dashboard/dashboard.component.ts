import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from "@angular/common/http";
import { Media } from '../models/Media';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public user: User;
  
  public medias : Array<Media> = [] ;
  constructor(
    private http: HttpClient
  ) {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.http.post("http://localhost:8082/PixoGramSpring/mymedia/getAll", this.user)
      .subscribe((data: any) => {
        data.forEach(media => {
          this.medias.push(media);
        });
      }
      ) 
  }

  ngOnInit() {
    //this.user = JSON.parse(sessionStorage.getItem('user'));
  }

}
