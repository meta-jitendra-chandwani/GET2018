import { Component, OnInit, Input } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../user.service';

@Component({
  selector: 'app-update-modal',
  templateUrl: './update-modal.component.html',
  styleUrls: ['./update-modal.component.css']
})
export class UpdateModalComponent implements OnInit {

  @Input() user;
  constructor(private modalService: NgbModal,
    private userService: UserService){
  }
  ngOnInit() {
  }

  updateOpen(content){
    debugger
    this.modalService.open(content);
  }
  
  save(): void {
    this.userService.updateUser(this.user).subscribe(() => console.log("Data Save"));
  }

}
