import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { DataServiceService } from '../services/data-service.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { Router } from '@angular/router';


@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {
  private cartList;
  private total = 0;
  constructor(
    private spinner: NgxSpinnerService,
    private dataService: DataServiceService,
    private router: Router) { }

  ngOnInit() {
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
      this.total += (list[i].Product.price * list[i].quantity);
    }
    this.total = Number(parseFloat(String(this.total)));
    // this.total.toFixed(2)

  }

  placedOrder() {
    this.router.navigate(['/order-success']);
    // this.dataService.saveOrderItem(this.cartList)
    this.dataService.deleteCartItem().subscribe((data) => {
      console.log("success");
    });
  }

}
