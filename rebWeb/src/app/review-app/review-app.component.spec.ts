import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewAppComponent } from './review-app.component';

describe('ReviewAppComponent', () => {
  let component: ReviewAppComponent;
  let fixture: ComponentFixture<ReviewAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReviewAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
