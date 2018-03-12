import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {



  constructor(private user: UserService, private router: Router) { }

  ngOnInit() {
  }

  userCurrent(e){
    // switch(e.target.elements[0].value){
    //   case("Profile"):{
    //     this.router.navigate(['profile']);
    //     break;
    //   }
    //   case("Application"):{
    //     this.router.navigate(['application']);
    //     break;
    //   }
    // }

  }
}
