import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Data } from '../fruits';
import { DataServiceService } from '../services/data-service.service'
import { Order } from '../order';
import { ShowCartItemComponent } from '../show-cart-item/show-cart-item.component'
import { Router } from '@angular/router';
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
  public cartArray: any[] = [];
  public booleanArray: boolean[] = [];
  public cartLength: number = 0;
  public value: number = -1;
  public length: number;

  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) { }

  ngOnInit() {
    this.categoryType(this.type);
  }


  routerClick() {
    debugger
    if (this.cartItemArray.length != 0) {
      this.dataService.saveCartItem(this.cartItemArray).subscribe(() => console.log("Data Save"));
    }
    this.router.navigate(['/shopping-cart']);
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

  quantityDecrease(product: Data) {
    debugger
    var i;
    this.cartArray[product.id]--;
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
    this.cartArray[product.id]++;
  }

  addToCart(product: Data): void {
    debugger
    this.value++;
    const cartItem: Order = new Order();
    cartItem.Product = product;
    cartItem.quantity = 1;
    this.cartItemArray.push(cartItem);
    this.booleanArray[product.id] = true;
    this.cartLength++;
    this.cartArray[product.id] = 1;

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
