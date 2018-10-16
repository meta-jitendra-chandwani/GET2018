import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UsersComponent } from './users/users.component';
import { ShowCartItemComponent } from './show-cart-item/show-cart-item.component';
import { RouterModule, Routes } from '@angular/router';
const routes: Routes = [
  { path: 'shopping-cart', component: ShowCartItemComponent, data: { "length": 0, "cartItemArray": [] } }
];
@NgModule({
  // exports: [RouterModule],
  declarations: [
    AppComponent,
    HomeComponent,
    UsersComponent,
    ShowCartItemComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
