import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Order } from '../order';
import { DataServiceService } from '../services/data-service.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-cart-item',
  templateUrl: './show-cart-item.component.html',
  styleUrls: ['./show-cart-item.component.css']
})
export class ShowCartItemComponent implements OnInit {

  @Output() childEventIncrease = new EventEmitter();
  @Output() childEventDecrease = new EventEmitter();
  @Output() lengthOfCart = new EventEmitter();
  @Output() cartItem = new EventEmitter();
  public length: number;
  public cartItemArray: Order;
  public cartList = null;
  public sub;
  public total: number = 0;
  constructor(
    private spinner: NgxSpinnerService,
    private dataService: DataServiceService,
    private router: Router) { }


  ngOnInit() {
    debugger
    this.spinner.show();

    setTimeout(() => {
      this.functionCall();
      this.spinner.hide();
    }, 500);
  }
  functionCall() {
    this.dataService.getCartItem().subscribe((data: Order[]) => {
      this.cartList = data[0],
        this.calculateTotal(this.cartList);
    });
  }

  calculateTotal(list) {
    var i;
    for (i = 0; i < list.length; i++) {
      this.total += list[i].Product.price * list[i].quantity;
    }
  }

  quantityDecrease(itemId: number) {
    debugger
    this.childEventDecrease.emit(itemId);
  }
  quantityIncrease(itemId: number) {
    debugger
    this.childEventIncrease.emit(itemId);
  }

  clearCart() {
    debugger
    this.cartList==null;
    this.dataService.deleteCartItem().subscribe((data) => {
      console.log("Cart Empty Successfully");
    });
  }

  checkout() {
    this.dataService.saveOrderItem(this.cartList).subscribe((data) => {
      console.log("Data Save to Order")
    });
    // this.dataService.deleteCartItem().subscribe((data) => {
    //   console.log("Cart Empty Successfully");
    // });
    this.router.navigate(['/check-out']);
  }
}