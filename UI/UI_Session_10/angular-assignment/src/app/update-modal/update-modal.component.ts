import { Component, OnInit, Input } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../user.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-update-modal',
  templateUrl: './update-modal.component.html',
  styleUrls: ['./update-modal.component.css']
})
export class UpdateModalComponent implements OnInit {

  userId: number;
  user:User;
  private sub: any;
  constructor(private modalService: NgbModal,
    private userService: UserService,
    private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.userId = params.id;
    });
   this.getUserById(this.userId);
  }

  getUserById(id:number):any{
    this.userService.getItemById(id).subscribe((response : User)=> this.user = response);
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  save(): void {
    this.userService.updateUser(this.user).subscribe(() => console.log("Data Save"));
  }

}
