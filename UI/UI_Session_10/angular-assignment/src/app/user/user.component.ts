import { Component, OnInit, Input, Output, EventEmitter, ViewChild, AfterViewInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { ModalBasicComponent } from '../modal-basic/modal-basic.component'
import { Subscriber } from '../../../node_modules/rxjs';
// import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public users = []
  public user: User;
  constructor(
    private userService: UserService
  ) { }

  @ViewChild(ModalBasicComponent) childModalComponent;

  show(user: User): void {
    debugger;
    this.childModalComponent.updateModal(user);
  }

  ngOnInit() {
    this.getUser();
  }

  getUser(): any {
    debugger
    return this.userService.getItems().subscribe((data) => this.users = data);
  }

}