import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Order } from '../order';

@Component({
  selector: 'app-show-cart-item',
  templateUrl: './show-cart-item.component.html',
  styleUrls: ['./show-cart-item.component.css']
})
export class ShowCartItemComponent implements OnInit {
  @Input() length: number;
  @Input() cartItemArray: Order[];
  @Output() childEventIncrease = new EventEmitter();
  @Output() childEventDecrease = new EventEmitter();
  constructor() { }

  ngOnInit() {
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
