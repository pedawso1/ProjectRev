import {Component, OnInit} from '@angular/core';
import {MenuItem, SelectItem} from 'primeng/api';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user.service';


@Component({
  selector: 'app-new-form',
  templateUrl: './new-form.component.html',
  styleUrls: ['./new-form.component.css']
})
export class NewFormComponent implements OnInit {

  evtType: SelectItem[];

  value: Date;
  descriptions: string = "";
  fForm: FormGroup;
  grdType: SelectItem[];
  items: MenuItem[];
  grade: number;
  event: number;

  constructor(private fb: FormBuilder, private router: Router, private user: UserService, private route: ActivatedRoute, private http: HttpClient) {

    this.evtType = [
      {label: 'Events', value: null},
      {label: 'University Courses', value: 1},
      {label: 'Seminars', value: 2},
      {label: 'Cert Prep Classes', value: 3},
      {label: 'Certification', value: 4},
      {label: 'Technical Training', value: 5},
      {label: 'Other', value: 6}

    ];
    this.grdType = [
      {label: 'Grades', value: null},
      {label: 'Presentation', value: 1},
      {label: 'Attendance Form', value: 2},
      {label: 'Grade Scale', value: 3},
    ];

  }




  ngOnInit() {
    this.fForm = this.fb.group({
      location: new FormControl('',Validators.required),
      cost: new FormControl('',Validators.required),
      work: new FormControl('',Validators.required),
      event: new FormControl('',Validators.required),
      grade: new FormControl('',Validators.required),
      date: new FormControl('',Validators.required),


    })

    if (!this.user.getUserManager()) {
//
      this.items = [
        {
          label: 'Profile', icon: 'fa-support', command: (event) => {
            this.router.navigate(['profile'])
          }
        },
        {
          label: 'New Forms', icon: 'fa-calendar', command: (event) => {
            this.router.navigate(['newForm'])
          }
        },
        {
          label: 'Current Forms', icon: 'fa-bar-chart', command: (event) => {
            this.router.navigate(['application'])
          }
        },

      ];

    }
    else {
      this.items = [
        {
          label: 'Profile', icon: 'fa-support', command: (event) => {
            this.router.navigate(['profile'])
          }
        },
        {
          label: 'New Forms', icon: 'fa-calendar', command: (event) => {
            this.router.navigate(['newForm'])
          }
        },
        {
          label: 'Current Forms', icon: 'fa-bar-chart', command: (event) => {
            this.router.navigate(['application'])
          }
        },
        {
          label: 'Review Forms', icon: 'fa-book', command: (event) => {
            this.router.navigate(['review'])
          }
        },

      ];
    }
  }

  loginUser(e) {
    //e.preventDefault();
    var url = 'http://localhost:9999/RevCo/NewForm';
    const req = this.http.post(url, {
      cost: this.fForm.value.cost,
      work: this.fForm.value.work,
      event: this.fForm.value.event,
      grade: this.fForm.value.grade,
      date: (this.fForm.value.date),
      location: this.fForm.value.location,
      description: this.descriptions,
      username: this.user.getUsername()

    })
      .subscribe(
        res => {

          var auth = JSON.parse(JSON.stringify(res));
          if (auth.Applied) {
            this.router.navigate(['application']);

          } else {
            this.router.navigate(['profile']);

          }

        },
        (err: HttpErrorResponse) => {
          if (err.error instanceof Error) {
            console.log('Client-side error occured.');
          } else {
            console.log('Server-side error occured.');
          }
        }
      );

  }

}
