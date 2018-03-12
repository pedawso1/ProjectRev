import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';

@Component({
  selector: 'app-appselect',
  templateUrl: './appselect.component.html',
  styleUrls: ['./appselect.component.css']
})
export class AppselectComponent implements OnInit {
userMgr: boolean;
  constructor(private user:UserService) {
    this.userMgr = this.user.getUserManager();
  }

  ngOnInit() {
  }

}
