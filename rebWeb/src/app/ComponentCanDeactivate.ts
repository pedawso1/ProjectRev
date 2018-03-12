import {Observable} from 'rxjs/Observable';

export interface ComponentCanDeactivate{
  canDeactive: () => boolean | Observable<boolean>;
}
