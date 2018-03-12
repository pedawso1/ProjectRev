import {Component, HostListener} from '@angular/core';
import * as $ from 'jquery' ;
import { FormsModule } from '@angular/forms';
import {ComponentCanDeactivate} from './ComponentCanDeactivate';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements ComponentCanDeactivate{
  isDirty: boolean = false;
  title = 'app';
  canDeactive(): boolean {
    return !this.isDirty
  }



}
