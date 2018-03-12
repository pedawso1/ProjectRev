import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HeaderComponent} from './header/header.component';
import {LoginFormComponent} from './login/login-form.component';
import {FooterComponent} from './footer/footer.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {RouterModule, Routes} from '@angular/router';
import {UserService} from './user.service';
import {AuthguardGuard} from './authguard.guard';
import {RejectComponent} from './reject/reject.component';
import {HttpClientModule} from '@angular/common/http';
import {ProfileComponent} from './profile/profile.component';
import {AccordionModule} from 'primeng/accordion';     //accordion and accordion tab
import {MenuItem} from 'primeng/api';
import {CodeHighlighterModule, DropdownModule, InputTextareaModule, InputTextModule, TabViewModule, CalendarModule, CheckboxModule, RadioButtonModule} from 'primeng/primeng';
import {ButtonModule} from 'primeng/button';
import {CarouselModule} from 'primeng/carousel';
import {PanelModule} from 'primeng/panel';
import {GrowlModule} from 'primeng/growl';                 //api
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {CardModule} from 'primeng/card';
import { ApplicationComponent } from './application/application.component';
import {TableModule} from 'primeng/table';
import { AppselectComponent } from './appselect/appselect.component';
import { NewFormComponent } from './new-form/new-form.component';
import { NoopAnimationsModule} from '@angular/platform-browser/animations';
import { ReviewAppComponent } from './review-app/review-app.component';
import {TriStateCheckboxModule} from 'primeng/tristatecheckbox';
import {SplitButtonModule} from 'primeng/splitbutton';
import {ToggleButtonModule} from 'primeng/togglebutton';
import {InputSwitchModule} from 'primeng/inputswitch';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService} from 'primeng/api';
import {MenuModule} from 'primeng/menu';
import {PanelMenuModule} from 'primeng/panelmenu';
import {DialogModule} from 'primeng/dialog';
import {OverlayPanelModule} from 'primeng/overlaypanel';
import {InplaceModule} from 'primeng/inplace';
import {DataTableModule} from 'primeng/datatable';
import {BlockUIModule} from 'primeng/blockui';
import {ChartModule} from 'primeng/chart';
import {TabMenuModule} from 'primeng/tabmenu';
import {SidebarModule} from 'primeng/sidebar';
import {DataScrollerModule} from 'primeng/datascroller';
import {FileUploadModule} from 'primeng/fileupload';

import {KeyFilterModule} from 'primeng/keyfilter';

const appRoutes = [
  {
    path: '',
    component: LoginFormComponent
  },
  {
    path: '',
    canActivate: [AuthguardGuard],
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'profile',
        component: ProfileComponent,

      },
      {
        path: 'appselect',
        component: AppselectComponent,

      },
      {
        path: 'review',
        component: ReviewAppComponent,

      },
      {
        path: 'newForm',
        component: NewFormComponent,

      },
      {
        path: 'application',
        component: ApplicationComponent,

      }

    ]
  },
  {
    path: 'reject',
    component: RejectComponent
  }
];

@NgModule({

  declarations: [

    AppComponent,
    HeaderComponent,
    LoginFormComponent,
    FooterComponent,
    DashboardComponent,
    RejectComponent,
    ProfileComponent,
    ApplicationComponent,
    AppselectComponent,
    NewFormComponent,
    ReviewAppComponent

  ],
  imports: [
    TabMenuModule,
    SidebarModule,
    DataTableModule,
    FormsModule,
    DataScrollerModule,
    ReactiveFormsModule,
    ChartModule,
    GrowlModule,
    PanelModule,
    DropdownModule,
    InplaceModule,
    InputTextModule,
    InputTextareaModule,
    ButtonModule,
    TabViewModule,
    BlockUIModule,
    CodeHighlighterModule,
    KeyFilterModule,
    HttpClientModule,
    BrowserModule,
    AccordionModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    OverlayPanelModule,
    MatButtonModule,
    MatCheckboxModule,
    CardModule,
    TableModule,
    CalendarModule,
    CheckboxModule,
    RadioButtonModule,
    DropdownModule,
    NoopAnimationsModule,
    TriStateCheckboxModule,
    FileUploadModule,
    SplitButtonModule,
    ToggleButtonModule,
    InputSwitchModule,
    ConfirmDialogModule,
    MenuModule,
    DialogModule,
    CarouselModule,
    PanelMenuModule
  ],
  providers: [UserService, AuthguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
