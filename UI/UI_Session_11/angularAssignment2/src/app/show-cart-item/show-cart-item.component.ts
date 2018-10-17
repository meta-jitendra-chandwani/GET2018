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
  public total:number=0;
  constructor(
    private dataService: DataServiceService, ) { }


  ngOnInit() {
    debugger
    this.getCartItem();

    alert(this.cartItem[0].quantity)
    // var i;
    // var total:number=0;
    // for (i = 0; i <= this.cartList.length; i++) {
    //   this.total += this.cartList[i].Product.price * this.cartList[i].quantity
    // }
    // this.length = this.cartList.length;
    // this.cartItemArray = this.cartList;
    // alert(this.cartList.Product[1].quantity)
  }

  getCartItem(): any {
    this.dataService.getCartItem().subscribe((data: Order[]) => this.cartList = data);
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  quantityDecrease(itemId: number) {
    debugger
    this.childEventDecrease.emit(itemId);
  }
  quantityIncrease(itemId: number) {
    debugger
    this.childEventIncrease.emit(itemId);
  }


}
