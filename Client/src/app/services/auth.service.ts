import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private status: boolean;
  constructor(
    private router: Router,
    private http: HttpClient,
  ) { }
  public user: User;
  login(user): boolean {

    this.http.post("http://localhost:8082/PixoGramSpring/account/login", user)
      .subscribe((res: User) => {
        console.log(res);
        this.user = res;
        if (this.user != null) {
          sessionStorage.setItem('user', JSON.stringify(this.user));
          this.router.navigateByUrl("/dashboard");
          

        }
        else {

          this.router.navigateByUrl("/login");
        }
      }
      )
    return this.status;
  }
  logout() {
    sessionStorage.removeItem('user');
    this.router.navigateByUrl("/login");
  }
  isUserLoggedIn() {
    let userString = sessionStorage.getItem('user');
    this.user = JSON.parse(userString);
    return !(this.user === null)
  }
}
