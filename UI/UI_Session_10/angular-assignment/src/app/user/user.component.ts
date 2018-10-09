import { Component, OnInit, Input, Output, EventEmitter, ViewChild, AfterViewInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { ModalBasicComponent } from '../modal-basic/modal-basic.component'
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
    // this.getItemsThroughId(x.id);
    this.childModalComponent.modalShow(user);
  }

  // getItemsThroughId(id: number): any {
  //   debugger
  //   return this.userService.getItemsThroughId(id).subscribe((user: User) => this.user = user);
  // }

  ngOnInit() {
    this.getUser();
  }

  getUser(): any {
    return this.userService.getItems().subscribe((data: User[]) => this.users = data);
  }

}