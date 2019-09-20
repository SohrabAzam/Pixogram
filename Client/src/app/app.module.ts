import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearchComponent } from './search/search.component';
import { UpdateComponent } from './update/update.component';
import { BlockedComponent } from './blocked/blocked.component';
import { NewsfeedComponent } from './newsfeed/newsfeed.component';
import { AuthService } from './services/auth.service';
import { UploadSingleMediaComponent } from './upload-single-media/upload-single-media.component';
import { UploadMultipleMediaComponent } from './upload-multiple-media/upload-multiple-media.component';
import { FollowersComponent } from './followers/followers.component';
import { MyMediaComponent } from './my-media/my-media.component';
import { LogoutComponent } from './logout/logout.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProfileComponent } from './profile/profile.component';
import { MediaDetailComponent } from './media-detail/media-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    SearchComponent,
    UpdateComponent,
    BlockedComponent,
    NewsfeedComponent,
    UploadSingleMediaComponent,
    UploadMultipleMediaComponent,
    FollowersComponent,
    MyMediaComponent,
    LogoutComponent,
    ProfileComponent,
    MediaDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
