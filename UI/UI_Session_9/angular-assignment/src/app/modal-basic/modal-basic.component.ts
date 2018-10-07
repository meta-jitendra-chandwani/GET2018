import { Component } from '@angular/core';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-basic',
  templateUrl: './modal-basic.component.html',
  styleUrls:['./modal-basic.component.css']
})
export class ModalBasicComponent {
  constructor(private modalService: NgbModal) { }

  open(content) {
    this.modalService.open(content);
  }
}