import { Component, Input } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../user.service';
import { NgForm } from '../../../node_modules/@angular/forms';
import { User } from '../user';

@Component({
  selector: 'app-modal-basic',
  templateUrl: './modal-basic.component.html',
  styleUrls: ['./modal-basic.component.css']
})
export class ModalBasicComponent {
  constructor(private modalService: NgbModal,
    private userService: UserService,
  ) { }

  users: User[];
  public user: User;
  content: string;
  modalBoolean: boolean = true;

  modalShow(user) {
    this.modalBoolean = false;
    this.user = user;
    this.modalService.open(this.content);
  }

  open(content) {
    this.user = null;
    this.modalBoolean = true;
    this.content = content;
    this.modalService.open(content);
  }

  addUser(name: string, mobile: string, location: string): void {
    debugger
    const newUser: User = new User();
    newUser.name = name;
    newUser.mobile = mobile;
    newUser.location = location;
    this.userService.addUser(newUser)
      .subscribe(insertedUser => {
        this.users.push(insertedUser);
      })
  }

  save(): void {
    this.userService.updateUser(this.user).subscribe(() => this.goBack("Data Save"));
    this.content = '';
  }
  goBack(message: string): void {
    console.log(message);

    this.modalService.dismissAll();
    this.content = '';
  }
}