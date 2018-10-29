import { Component, OnInit, Input, Output, EventEmitter, ViewChild, AfterViewInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { ModalBasicComponent } from '../modal-basic/modal-basic.component'
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public users = []
  public user: User;
  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.getUser();
  }

  getUser(): any {
    return this.userService.getItems().subscribe((response) => this.users = response);
  }

  updateModal(user:User){
    this.router.navigate(['/modal',user.id]);
  }

}