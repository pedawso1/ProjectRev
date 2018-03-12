import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppselectComponent } from './appselect.component';

describe('AppselectComponent', () => {
  let component: AppselectComponent;
  let fixture: ComponentFixture<AppselectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppselectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppselectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
