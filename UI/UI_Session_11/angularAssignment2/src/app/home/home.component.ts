import { Component, OnInit } from '@angular/core';
import { Data } from '../fruits';
import { DataServiceService } from '../services/data-service.service'
import { AddToCartServiceService } from '../services/add-to-cart-service.service'
import { Order } from '../order';
import { AfterViewInit, ViewChild } from '@angular/core';
import { ShowCartItemComponent } from '../show-cart-item/show-cart-item.component'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public data = [];
  public type: string = "all";
  public add: boolean = true;
  public addInCart: boolean = false;
  public selectedIdx: number;
  public cartCount:number=0;
  public cartItemArray: Order[] = [{
    "id": null,
    "productName": "",
    "price": null,
    "quantity": null
  }];
  public booleanArray: boolean[] = [];
  public cartLength: number = 0;
  constructor(
    private dataService: DataServiceService,
    private addToCartService: AddToCartServiceService
  ) { }

  // @ViewChild(ShowCartItemComponent)
  // private showCartComponent: ShowCartItemComponent;


  ngOnInit() {
    this.categoryType(this.type);
  }

  categoryType(type: string) {
    this.type = type;
    this.data = [];
    if (type == "all") {
      this.getAll();
    }
    if (type == "fruits") {
      this.getFruits();
    }
    if (type == "vegetables") {
      this.getVegetables();
    }
    if (type == "bread") {
      this.getBreads();
    }
    if (type == "dairy") {
      this.getDairy();
    }
  }

  quantityDecrease(productId: number) {
    debugger
    this.cartItemArray[productId].quantity--;
    if (this.cartItemArray[productId].quantity == 0) {
      this.cartLength--;
      this.booleanArray[productId] = false;
      this.cartItemArray[productId] = null;
    }
  }
  quantityIncrease(productId: number) {
    debugger
    this.cartItemArray[productId].quantity++;
  }

  addToCart(product: Data): Order[] {
    debugger
    const cartItem: Order = new Order();
    cartItem.id=++this.cartLength;
    cartItem.price = product.price;
    cartItem.productName = product.name;
    cartItem.quantity = 1;
    this.cartItemArray[product.id] = cartItem;
    this.booleanArray[product.id] = true;
    // this.cartLength++;
    return this.cartItemArray;
  }

  getDairy(): any {
    return this.dataService.getDairyItems().subscribe((data: Data[]) => this.data = data);
  }
  getBreads(): any {
    return this.dataService.getBreadsItems().subscribe((data: Data[]) => this.data = data);
  }
  getVegetables(): any {
    return this.dataService.getVegetablesItems().subscribe((data: Data[]) => this.data = data);
  }
  getAll(): any {
    return this.dataService.getAllItems().subscribe((data: Data[]) => this.data = data);
  }
  getFruits(): any {
    debugger
    return this.dataService.getFruitsItems().subscribe((data: Data[]) => this.data = data);
  }
}
