import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user.service';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {ConfirmationService, MenuItem, Message} from 'primeng/api';


@Component({
  selector: 'app-review-app',
  providers: [ConfirmationService],
  templateUrl: './review-app.component.html',
  styleUrls: ['./review-app.component.css'],
  styles: ['.ui-grid-row .grey{' +
  'text-align:center;' +
  'background: grey}' +
  '.ui-grid{' +
  'margin: 10px 0px;' +
  '}' +
  '.ui-grid-row > div{' +
  ' paddingL 4px 10px;' +
  '}' +
  '.ui-grid-row{' +
    'text-align:center;}'

  ]
})
export class ReviewAppComponent implements OnInit {


  constructor(private router: Router, private user: UserService, private route: ActivatedRoute, private http: HttpClient, private confirmationService: ConfirmationService) {
  }

  form: any;
  cols: any;
  formId: string;
  event: string;
  date: any;
  approve: boolean;
  cost: string;
  location: string;
  description: string;
  currentRev: boolean = true;
  submitWarn: boolean;
  workExcuse: string;
  msgs: Message[];
  items: MenuItem[];
  rowValue: boolean;

  ngOnInit() {
    if (this.user.getUserManager()) {
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






    var url = 'http://localhost:9999/RevCo/reviewServlet';
    const req = this.http.post(url, {
      userName: this.user.getUsername()
    })
      .subscribe(
        res => {
          this.form = JSON.parse(JSON.stringify(res));

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
    // if(f.submitWarn){
    //   this.msgs.push({severity: 'danger', summary: 'URGENT', detail: 'EVENT STARTS:' + f.date + " " + f.time});
    // }
    // else
    if (f.warn == 0) {
      this.msgs.push({severity: 'danger', summary: 'Expiration Warning', detail: 'Submitted::' + f.date + " " + f.time});
    }
    else if (f.warn == (-1)) {
      this.msgs.push({severity: 'warning', summary: 'Expiration Notice', detail: 'Submitted:' + f.date + " " + f.time});

    } else if (f.warn == (-2)) {
      this.msgs.push({severity: 'success', summary: 'New Form', detail: 'Submitted:' +  f.date + " " + f.time});

    }
  }


  save(selectedItem: any, e: boolean, choice: string) {

    var url = 'http://localhost:9999/RevCo/approve';
    var check = this.confirmationService.confirm({
        message: 'Are you sure that you want to perform this action?',

        accept: () => {
          this.http.post(url, {
            userName: this.user.getUsername(),
            id: selectedItem.valueOf(this.formId),
            currentReview: e,

          })
            .subscribe(
              res => {
                console.log(this.currentRev);
                var checks = JSON.parse(JSON.stringify(res));

                if (checks) {
                  this.rowValue = checks;
                  console.log('Smort');
                } else {
                  this.rowValue = checks;
                }
              },
              (err: HttpErrorResponse) => {
                if (err.error instanceof Error) {
                  console.log('Client-side error occured.');
                } else {
                  console.log('Server-side error occured.s');
                }
              }
            );

        }
      }
    );

  }

}
