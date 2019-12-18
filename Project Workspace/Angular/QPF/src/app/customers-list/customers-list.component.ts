import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { CustomerService } from '../customer.service';
import { Customer } from '../customer';
import { SelectItem } from 'primeng/api'
import { timelines } from '../timelines';
@Component({
  selector: 'customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {
  timelinesItemList: SelectItem[] = [{ label: "Select Timeline", value: "null" }];
  selectedTimeline: timelines = null;
  selectedValues = [];
  achievmentsList: SelectItem[];
  selectedAchievement: timelines = null;

  value: Date;
  dateValue: Date;
  minDateValue: Date;
  maxDateValue: Date;
  timelines: timelines[];
  fieldArray = [];
  customers: Observable<Customer[]>;

  tableHeader = ["Timelines", "My Achievement", "Summary", "Details"];
  items = [
    {
      header: "Header 1",
      content: "Content 1 Data"
    },
    {
      header: "Header 2",
      content: "Content 2 Data"
    },
    {
      header: "Header 3",
      content: "Content 3 Data"
    },
    {
      header: "Header 4",
      content: "Content 4 Data"
    },
    {
      header: "Header 5",
      content: "Content 5 Data"
    },
    {
      header: "Header 6",
      content: "Content 6 Data"
    }
  ]
  constructor(private customerService: CustomerService) {
    this.fieldArray = [{ selectedTimeline: null }]    // this.timelines = [
    //   { id: 0, timelinePeriod: "Week : Oct 1" },
    //   { id: 1, timelinePeriod: "Week : Oct 8" },
    //   { id: 2, timelinePeriod: "Week : Oct 15" },
    //   { id: 3, timelinePeriod: "Week : Oct 22" },
    //   { id: 4, timelinePeriod: "Week : Oct 29" },
    //   { id: 5, timelinePeriod: "Week : Oct 1" },
    // ];
    // this.timelinesItemList = [
    //   { label: 'Select Timeline', value: null },
    //   { label: "Week : Oct 1", value: { id: 0, timelinePeriod: "Week : Oct 1" } },
    //   { label: "Week : Oct 8", value: { id: 1, timelinePeriod: "Week : Oct 8" } },
    //   { label: "Week : Oct 15", value: { id: 2, timelinePeriod: "Week : Oct 15" } },
    //   { label: "Week : Oct 23", value: { id: 3, timelinePeriod: "Week : Oct 23" } },
    // ];
    // this.achievmentsList = [
    //   { label: 'Select Achievements', value: null },
    //   { label: "Nothing", value: { id: 0, timelinePeriod: "Week : Oct 1" } },
    //   { label: "Week : Oct 8", value: { id: 1, timelinePeriod: "Week : Oct 8" } },
    //   { label: "Week : Oct 15", value: { id: 2, timelinePeriod: "Week : Oct 15" } },
    //   { label: "Week : Oct 23", value: { id: 3, timelinePeriod: "Week : Oct 23" } },
    // ];

  }
  show(value: string) {
    alert(value)
  }

  ngOnInit() {
    this.getTimeline();
    // this.reloadData();
  }

  getTimeline() {
    return this.customerService.getTimelines().subscribe((response) => {
      this.timelinesItemList = this.transform(response);
    });
  }

  public transform(timelines: timelines[]): SelectItem[] {
    debugger
    if (!timelines) return undefined;
    return timelines.map(timeline => ({ label: timeline.timelinePeriod, value: timeline.timelinePeriod }));
  }

  deleteCustomers() {
    this.customerService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.customers = this.customerService.getCustomersList();
  }
  handleClick() {
    //execute action
  }
  addRow() {
    let addNewTimelineObject = { selectedTimeline: null }
    // this.fieldArray.length++;
    this.fieldArray.push(addNewTimelineObject);
  }
  deleteRow(data: any) {
    debugger
    let index = this.fieldArray.indexOf(data);
    if (index > -1) {
      this.fieldArray.splice(index, 1);
    }
  }
}