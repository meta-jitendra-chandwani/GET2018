import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCartItemComponent } from './show-cart-item.component';

describe('ShowCartItemComponent', () => {
  let component: ShowCartItemComponent;
  let fixture: ComponentFixture<ShowCartItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowCartItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCartItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
