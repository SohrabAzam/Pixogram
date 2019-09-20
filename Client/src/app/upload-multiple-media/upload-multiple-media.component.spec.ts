import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadMultipleMediaComponent } from './upload-multiple-media.component';

describe('UploadMultipleMediaComponent', () => {
  let component: UploadMultipleMediaComponent;
  let fixture: ComponentFixture<UploadMultipleMediaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadMultipleMediaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadMultipleMediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
