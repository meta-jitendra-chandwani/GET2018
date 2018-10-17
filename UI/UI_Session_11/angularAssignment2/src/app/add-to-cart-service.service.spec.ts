import { TestBed } from '@angular/core/testing';

import { AddToCartServiceService } from './add-to-cart-service.service';

describe('AddToCartServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddToCartServiceService = TestBed.get(AddToCartServiceService);
    expect(service).toBeTruthy();
  });
});
