import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { ModalBasicComponent } from './modal-basic/modal-basic.component';
import { Routes, RouterModule } from '../../node_modules/@angular/router';
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: UserComponent },
  { path: 'add-user', component: ModalBasicComponent },
  { path: 'update-user/:id', component: ModalBasicComponent },
];
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
