import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';

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

  ngOnInit() {
    this.getUser();
  }

  getUser(): any {
    return this.userService.getItems().subscribe((data: User[]) => this.users = data);
  }
  addUser(): void {
    this.userService.addUser(this.user).subscribe(
      (data: User) => {
        console.log(data);

      },
      (error: any) => console.log(error)
    );
  }
}