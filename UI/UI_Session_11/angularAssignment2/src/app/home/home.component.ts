import { Component, OnInit } from '@angular/core';
import { Fruits } from '../fruits';
import { DataServiceService } from '../services/data-service.service'
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public fruits = []
  constructor(
    private dataService: DataServiceService
  ) { }

  ngOnInit() {
    this.getFruits();
  }

  getFruits(): any {
    debugger
    return this.dataService.getItems().subscribe((data: Fruits[]) => this.fruits = data);
  }

}
