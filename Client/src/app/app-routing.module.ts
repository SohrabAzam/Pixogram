import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearchComponent } from './search/search.component';
import { UpdateComponent } from './update/update.component';
import { BlockedComponent } from './blocked/blocked.component';
import { NewsfeedComponent } from './newsfeed/newsfeed.component';
import { UploadSingleMediaComponent } from './upload-single-media/upload-single-media.component';
import { UploadMultipleMediaComponent } from './upload-multiple-media/upload-multiple-media.component';
import { FollowersComponent } from './followers/followers.component';
import { MyMediaComponent } from './my-media/my-media.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuardService } from './services/auth-guard.service';
import { ProfileComponent } from './profile/profile.component';
import { MediaDetailComponent } from './media-detail/media-detail.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuardService] },
  { path: 'search', component: SearchComponent, canActivate: [AuthGuardService] },
  { path: 'update', component: UpdateComponent, canActivate: [AuthGuardService] },
  { path: 'blocked', component: BlockedComponent, canActivate: [AuthGuardService] },
  { path: 'newsfeed', component: NewsfeedComponent, canActivate: [AuthGuardService] },
  { path: 'upload', component: UploadSingleMediaComponent, canActivate: [AuthGuardService] },
  { path: 'uploadmulti', component: UploadMultipleMediaComponent, canActivate: [AuthGuardService] },
  { path: 'followers', component: FollowersComponent, canActivate: [AuthGuardService] },
  { path: 'media', component: MyMediaComponent, canActivate: [AuthGuardService] },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardService] },
  { path: 'profile/:userId', component: ProfileComponent, canActivate: [AuthGuardService] },
  { path: 'mediaDetail/:mediaId', component: MediaDetailComponent, canActivate: [AuthGuardService] },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
