import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ShowCartItemComponent } from './show-cart-item/show-cart-item.component';
import { RouterModule, Routes } from '@angular/router';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';
import { NgxSpinnerModule } from 'ngx-spinner';
import { CheckOutComponent } from './check-out/check-out.component';
import { OrderSuccessComponent } from './order-success/order-success.component';

const routes: Routes = [
  { path: '', redirectTo: '/home-cart', pathMatch: 'full' },
  { path: 'shopping-cart', component: ShowCartItemComponent },
  { path: 'home-cart', component: HomeComponent },
  { path: 'check-out', component: CheckOutComponent },
  { path: 'order-success', component: OrderSuccessComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ShowCartItemComponent,
    CheckOutComponent,
    OrderSuccessComponent,
  ],
  imports: [
    Ng4LoadingSpinnerModule.forRoot(),
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    NgxSpinnerModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
