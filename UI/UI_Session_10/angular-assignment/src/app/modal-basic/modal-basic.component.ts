import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-modal-basic',
  templateUrl: './modal-basic.component.html',
  styleUrls: ['./modal-basic.component.css']
})
export class ModalBasicComponent {

  public users: User[];
  // public user: User;
  // public content: string;
  // public modalBoolean: boolean = true;

  constructor(private modalService: NgbModal,
    private userService: UserService,
  ) { }

  // updateModal(user) {
  //   this.modalBoolean = false;
  //   this.user = user;
  //   this.modalService.open(this.content);
  // }

  openModal(content) {
    debugger
    // this.user = null;
    // this.modalBoolean = true;
    // this.content = content;
    this.modalService.open(content);
  }

  addUser(name: string, mobile: string, location: string): void {
    this.userService.addUser(new User(name, mobile, location))
      .subscribe(insertedUser => {
        this.users.push(insertedUser);
      })
  }

  // save(): void {
  //   this.userService.updateUser(this.user).subscribe(() => console.log("Data Save"));
  // }
}