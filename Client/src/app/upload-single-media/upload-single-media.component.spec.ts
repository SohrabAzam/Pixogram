import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadSingleMediaComponent } from './upload-single-media.component';

describe('UploadSingleMediaComponent', () => {
  let component: UploadSingleMediaComponent;
  let fixture: ComponentFixture<UploadSingleMediaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadSingleMediaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadSingleMediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
