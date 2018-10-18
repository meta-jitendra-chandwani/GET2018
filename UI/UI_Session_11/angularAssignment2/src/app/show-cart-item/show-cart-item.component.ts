import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Order } from '../order';
import { ActivatedRoute } from '@angular/router'
import { DataServiceService } from '../services/data-service.service';
import { validateConfig } from '../../../node_modules/@angular/router/src/config';
@Component({
  selector: 'app-show-cart-item',
  templateUrl: './show-cart-item.component.html',
  styleUrls: ['./show-cart-item.component.css']
})
export class ShowCartItemComponent implements OnInit {
  // @Input() length: number;
  // @Input() cartItemArray: Order[];
  @Output() childEventIncrease = new EventEmitter();
  @Output() childEventDecrease = new EventEmitter();
  @Output() lengthOfCart = new EventEmitter();
  @Output() cartItem = new EventEmitter();
  public length: number;
  public cartItemArray: Order;
  public cartList: Order[] = [];
  public sub;
  public total: number = 0;
  constructor(
    private dataService: DataServiceService, ) { }


  ngOnInit() {
    this.getCartItem();
  }

  getCartItem(): any {
    // alert("Data")
    this.dataService.getCartItem().subscribe((data: Order[]) => this.cartList = data);
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
    this.dataService.deleteCartItem().subscribe((data) => {
      console.log("success");
    });
  }


}
