import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../user.service';
import { User } from '../user';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-modal-basic',
  templateUrl: './modal-basic.component.html',
  styleUrls: ['./modal-basic.component.css']
})
export class ModalBasicComponent {

  public users: User[];
  userId: number;
  user:User;
  private sub: any;
  // public user: User;
  // public content: string;
  public modalBoolean: boolean = true;

  constructor(private modalService: NgbModal,
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  openModal(content) {
    debugger
    this.user = null;
    this.modalBoolean = true;
    this.modalService.open(content);
  }

  addUser(name: string, mobile: string, location: string): void {
    this.userService.addUser(new User(name, mobile, location))
      .subscribe(insertedUser => {
        this.users.push(insertedUser);
      })
      this.router.navigate(['./home']);
  }


  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.userId = params.id;
    });
   this.getUserById(this.userId);
  }

  getUserById(id:number):any{
    this.modalBoolean=false;
    this.userService.getItemById(id).subscribe((response : User)=> this.user = response);

  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  save(): void {
    this.userService.updateUser(this.user).subscribe(() => console.log("Data Save"));
    this.router.navigate(['/home']);
  }
}