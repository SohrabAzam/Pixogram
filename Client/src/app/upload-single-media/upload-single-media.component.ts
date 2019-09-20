import { Component, OnInit } from '@angular/core';
import { Media } from '../models/Media';
import { FormsModule } from '@angular/forms';
import { User } from '../models/User';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-upload-single-media',
  templateUrl: './upload-single-media.component.html',
  styleUrls: ['./upload-single-media.component.css']
})
export class UploadSingleMediaComponent implements OnInit {
  public imagePath;
  imgURL: any;
  public media : Media = new Media();
  public message: string;
  constructor( 
    private http: HttpClient
   ) { }
  public user : User = new User();
  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
  }

preview(files) {
    if (files.length === 0)
      return;
 
   // var mimeType = files[0].type;
   // if (mimeType.match(/image\/*/) == null) {
    //  this.message = "Only images are supported.";
     // return;
    //}
 
    var reader = new FileReader();
    this.imagePath = files;
    reader.readAsDataURL(files[0]); 
    reader.onload = (_event) => { 
      this.imgURL = reader.result; 
    }
    this.media.fileSize = files[0].size;
    this.media.fileName = files[0].name;
    this.media.fileType = files[0].type;
    if(this.media.fileType.includes("image")){
      this.media.type = "Image";
    }
    else{
      this.media.type = "Video";
    }
    
  }
  successMessage : string;
  failureMessage : string;
  success : boolean;
  upload(){
    this.media.poster = "poster.jpeg";
    this.media.userId = this.user.userId;
    this.media.userName = this.user.username;
    this.http.post("http://localhost:8082/PixoGramSpring/media/uploadSingle",this.media)
    .subscribe((data : any) =>{
      this.success = true;
      this.successMessage = "Uploaded Successfully";
    },
    error => {
      this.success = false;
      this.failureMessage = "Upload was unsuccessful";
    }
    )
  }

  sepia(){
    this.media.effect = "Sepia";
  }

  grey(){
    this.media.effect = "Grey";
  }

  brighten(){
    this.media.effect = "Brighten";
  }

  contrast(){
    this.media.effect = "Contrast";
  }
  
}
