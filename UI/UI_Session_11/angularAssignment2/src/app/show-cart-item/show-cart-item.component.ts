import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../order';

@Component({
  selector: 'app-show-cart-item',
  templateUrl: './show-cart-item.component.html',
  styleUrls: ['./show-cart-item.component.css']
})
export class ShowCartItemComponent implements OnInit {
  @Input() length:number;
  // @Input() cartItem:Order[];
  constructor() { }

  ngOnInit() {
    alert("Hi"+this.length)
  }

}
