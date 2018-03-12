import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate} from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {ComponentCanDeactivate} from './ComponentCanDeactivate';

@Injectable()
export class PendingGuard implements CanDeactivate<ComponentCanDeactivate> {
  canDeactivate(component: ComponentCanDeactivate): Observable<boolean> | boolean {
    if(component.canDeactive()){
      return true;
    }else{
      confirm("Unfinished Inputs");
    }
  }
}
