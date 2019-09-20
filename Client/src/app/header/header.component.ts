import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { User } from '../models/User';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user: User;

  
  constructor(
    public authService: AuthService
    ) {
     
     }

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
  }
}
