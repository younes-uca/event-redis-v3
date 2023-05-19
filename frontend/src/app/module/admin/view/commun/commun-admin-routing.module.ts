
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { EvenementStateListAdminComponent } from './evenement-state-admin/list-admin/evenement-state-list-admin.component';
import { SalleListAdminComponent } from './salle-admin/list-admin/salle-list-admin.component';
import { BlocOperatoirListAdminComponent } from './bloc-operatoir-admin/list-admin/bloc-operatoir-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'evenement-state',
                            children: [
                                {
                                    path: 'list',
                                    component: EvenementStateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'salle',
                            children: [
                                {
                                    path: 'list',
                                    component: SalleListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'bloc-operatoir',
                            children: [
                                {
                                    path: 'list',
                                    component: BlocOperatoirListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class CommunAdminRoutingModule { }
