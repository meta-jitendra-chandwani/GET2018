import { Component, OnInit } from '@angular/core';
import { Data } from '../fruits';
// import { Vegetables } from '../vegetables';
import { DataServiceService } from '../services/data-service.service'
import { getAllDebugNodes } from '../../../node_modules/@angular/core/src/debug/debug_node';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public fruits = []
  public vegetables = [];
  public all = [];
  public data = [];
  public type: string = "all";
  // public isActive: boolean = true;
  constructor(
    private dataService: DataServiceService
  ) { }

  ngOnInit() {
    this.categoryType(this.type);
  }

  categoryType(type: string) {
    debugger
    // this.isActive = !this.isActive;
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
