import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from "primeng/fileupload";

import { EvenementStateCreateAdminComponent } from './evenement-state-admin/create-admin/evenement-state-create-admin.component';
import { EvenementStateEditAdminComponent } from './evenement-state-admin/edit-admin/evenement-state-edit-admin.component';
import { EvenementStateViewAdminComponent } from './evenement-state-admin/view-admin/evenement-state-view-admin.component';
import { EvenementStateListAdminComponent } from './evenement-state-admin/list-admin/evenement-state-list-admin.component';
import { SalleCreateAdminComponent } from './salle-admin/create-admin/salle-create-admin.component';
import { SalleEditAdminComponent } from './salle-admin/edit-admin/salle-edit-admin.component';
import { SalleViewAdminComponent } from './salle-admin/view-admin/salle-view-admin.component';
import { SalleListAdminComponent } from './salle-admin/list-admin/salle-list-admin.component';
import { BlocOperatoirCreateAdminComponent } from './bloc-operatoir-admin/create-admin/bloc-operatoir-create-admin.component';
import { BlocOperatoirEditAdminComponent } from './bloc-operatoir-admin/edit-admin/bloc-operatoir-edit-admin.component';
import { BlocOperatoirViewAdminComponent } from './bloc-operatoir-admin/view-admin/bloc-operatoir-view-admin.component';
import { BlocOperatoirListAdminComponent } from './bloc-operatoir-admin/list-admin/bloc-operatoir-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    EvenementStateCreateAdminComponent,
    EvenementStateListAdminComponent,
    EvenementStateViewAdminComponent,
    EvenementStateEditAdminComponent,
    SalleCreateAdminComponent,
    SalleListAdminComponent,
    SalleViewAdminComponent,
    SalleEditAdminComponent,
    BlocOperatoirCreateAdminComponent,
    BlocOperatoirListAdminComponent,
    BlocOperatoirViewAdminComponent,
    BlocOperatoirEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
  ],
  exports: [
  EvenementStateCreateAdminComponent,
  EvenementStateListAdminComponent,
  EvenementStateViewAdminComponent,
  EvenementStateEditAdminComponent,
  SalleCreateAdminComponent,
  SalleListAdminComponent,
  SalleViewAdminComponent,
  SalleEditAdminComponent,
  BlocOperatoirCreateAdminComponent,
  BlocOperatoirListAdminComponent,
  BlocOperatoirViewAdminComponent,
  BlocOperatoirEditAdminComponent,
  ],
  entryComponents: [],
})
export class CommunAdminModule { }