import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-modal-basic',
  templateUrl: './modal-basic.component.html',
  styleUrls: ['./modal-basic.component.css']
})
export class ModalBasicComponent {

  private userId: number;
  private user: User;
  private sub: any;
  private modalBoolean: boolean = true;

  constructor(
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) { }
  
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      if (params.id != undefined) {
        this.userId = params.id;
      }
    });
    this.userId ? this.getUserById(this.userId) : 0;
  }

  addUser(name: string, mobile: string, location: string): void {
    this.userService.addUser(new User(name, mobile, location))
      .subscribe();
    this.router.navigate(['./home']);
  }

  getUserById(id: number): any {
    this.modalBoolean = false;
    this.userService.getUserById(id).subscribe((response: User) => this.user = response);
  }

  save(): void {
    this.userService.updateUser(this.user).subscribe(() => console.log("Data Save"));
    this.router.navigate(['/home']);
  }

  close(){
    this.router.navigate(['/home']);
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}