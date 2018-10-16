import { Component, OnInit } from '@angular/core';
import { Data } from '../fruits';
import { DataServiceService } from '../services/data-service.service'
import { AddToCartServiceService } from '../services/add-to-cart-service.service'
import { Order } from '../order';
import { AfterViewInit, ViewChild } from '@angular/core';
import { ShowCartItemComponent } from '../show-cart-item/show-cart-item.component'
import { ActivatedRoute } from '../../../node_modules/@angular/router';

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
  public cartCount: number = 0;
  public cartItemArray: Order[] = [];
  public booleanArray: boolean[] = [];
  public cartLength: number = 0;
  constructor(
    private dataService: DataServiceService,
    private route: ActivatedRoute
  ) { }


  ngOnInit() {
    this.categoryType(this.type);
  }

  getCartItemArray(l): Order[] {
    debugger
    return this.cartItemArray;
  }

  getCartLength(a): number {
    debugger
    return this.cartLength;
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


  addToJson(): void {
    debugger
    this.dataService.saveCartItem(this.cartItemArray)
      .subscribe();
  }


  quantityDecrease(product: Data) {
    debugger

    var i;
    for (i = 0; i <= this.cartItemArray.length; i++) {
      if (this.cartItemArray[i].Product == product) {
        this.cartItemArray[i].quantity--;
        if (this.cartItemArray[i].quantity == 0) {
          this.cartLength--;
          this.booleanArray[product.id] = false;
          this.cartItemArray.splice(i, 1)
        }
        break;
      }
    }
  }
  quantityIncrease(product: Data) {
    debugger
    var i;
    for (i = 0; i <= this.cartItemArray.length; i++) {
      if (this.cartItemArray[i].Product == product) {
        this.cartItemArray[i].quantity++;
        break;
      }
    }
  }

  addToCart(product: Data): void {
    debugger
    const cartItem: Order = new Order();
    cartItem.Product = product;
    cartItem.quantity = 1;
    this.cartItemArray.push(cartItem);
    this.booleanArray[product.id] = true;
    this.cartLength++;
    // return this.cartItemArray;
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
