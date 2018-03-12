import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user.service';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {MenuItem, Message} from 'primeng/api';


@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css'],
  styles: ['.ui-grid-row{' +
  'text-align:center;}' +
  '.ui-grid{' +
  'margin: 10px 0px;' +
  '}' +
  '.ui-grid-row > div{' +
  ' paddingL 4px 10px;' +
  '}'

  ],



})
export class ApplicationComponent implements OnInit {


  constructor(private router: Router, private user: UserService, private route: ActivatedRoute, private http: HttpClient) {
  }
  comments: any;
  msgs: Message[];
  form: any;
  cols: any;
  formId: string;
  date: any;
  display;
  cost: string;
  location: string;
  event: string;
  approve: boolean;
  description: string;
  workExcuse: string;
  submitWarn: boolean;
  newForm: any;
  items: MenuItem[];
  ngOnInit() {


    if (!this.user.getUserManager()) {
//
      this.items = [
        {label: 'Profile', icon: 'fa-support',command:(event) =>{  this.router.navigate(['profile'])}},
        {label: 'New Forms', icon: 'fa-calendar',command:(event) =>{  this.router.navigate(['newForm'])}},
        {label: 'Current Forms', icon: 'fa-bar-chart',command:(event) =>{  this.router.navigate(['application'])}},

      ];

    }
    else {
      this.items = [
        {label: 'Profile', icon: 'fa-support',command:(event) =>{  this.router.navigate(['profile'])}},
        {label: 'New Forms', icon: 'fa-calendar',command:(event) =>{  this.router.navigate(['newForm'])}},
        {label: 'Current Forms', icon: 'fa-bar-chart',command:(event) =>{  this.router.navigate(['application'])}},
        {label: 'Review Forms', icon: 'fa-book',command:(event) =>{  this.router.navigate(['review'])}},

      ];
    }

    var url = 'http://localhost:9999/RevCo/FormServlet';
    const req = this.http.post(url, {
      userName: this.user.getUsername()
    })
      .subscribe(
        res => {
         this.form =  JSON.parse(JSON.stringify(res));
          this.cols = [
          {field:'formId', header:'ID'},
          {field:'cost', header: 'Cost'},
          {field:'location', header: 'Location'},
          {field: 'description', header: 'Description'},
          {field: 'date', header: 'Date'},
          {field: 'event', header: 'Event'},
          {field: 'workExcuse', header: 'Reason'},
            {field: 'warn', header: 'warn'}

        ]

          this.location = this.form.location;
          this.formId = this.form.formId;
          this.cost = this.form.cost;
          this.date = this.form.date;
          this.workExcuse = this.form.workExcuse;
          this.event = this.form.event;
          this.description = this.form.description;
          this.approve = this.form.approve;
          this.submitWarn = this.form.submitWarn;

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
  selectForm(f: any) {
    this.msgs = [];
    if(f.submitWarn){
      this.msgs.push({severity: 'danger', summary: 'URGENT', detail: 'Submitted:' + f.date + " " + f.time});
    }
    else if (f.warn == 0) {
      this.msgs.push({severity: 'danger', summary: 'Expiration Warning', detail: 'Submitted:' + f.date + " " + f.time});
    }
    else if (f.warn == (-1)) {
      this.msgs.push({severity: 'warning', summary: 'Expiration Notice', detail: 'Submitted:' + f.date + " " + f.time});

    } else if (f.warn == (-2)) {
      this.msgs.push({severity: 'success', summary: 'New Form', detail: 'Submitted:' +  f.date + " " + f.time});

    }
  }

post: any;

  commentLog(e){ var url = 'http://localhost:9999/RevCo/comment';
    const req = this.http.post(url, {
     id: e.formId,
     username: this.user.getUserManager(),
     comment: e.target.elements[0].value


    })
      .subscribe(
        res => {


        }
      );

  }
}


