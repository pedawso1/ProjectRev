import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {UserService} from '../user.service';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpErrorResponse} from '@angular/common/http';
import {CardModule} from 'primeng/card';
import {MenuItem} from 'primeng/api';

@Component(<Component>{
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css',
  ],

})
export class ProfileComponent implements OnInit {
  id = "";
  nameF = "";
  nameL = "";
  usern = "";
  pass = "";
  dept = "";
  mgr = "";
  reim : number;
  items: MenuItem[];
  pend: number;
  remain: number;

  data: any;
  constructor(private router: Router, private user: UserService, private route: ActivatedRoute, private http: HttpClient) {


  }


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



      var url = 'http://localhost:9999/RevCo/ProfileServlet';
    const req = this.http.post(url, {
      userName: this.user.getUsername()
    })
      .subscribe(
        res => {

          var auth = JSON.parse(JSON.stringify(res));
          this.id = auth.id;
          this.nameF = auth.first;
          this.nameL = auth.last;
          this.usern = auth.user;
          this.pass = auth.pass;
          this.dept = auth.dept;
          this.mgr = auth.manager;
          this.reim = auth.reim;
          this.pend = auth.pend;
          this.remain = (1000 - this.reim);
          this.wheel(this.pend,this.reim,this.remain)

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

wheel(x,y,z){
  this.data = {
    labels: ['PENDING','REIMBURSED','REMAINING'],
    datasets: [
      {

        data: [x,y,z],
        backgroundColor: [
          "#FF6384",
          "#36A2EB",
          "#FFCE56"
        ],
        hoverBackgroundColor: [
          "#FF6384",
          "#36A2EB",
          "#FFCE56"
        ]
      }]
  };
}
}



