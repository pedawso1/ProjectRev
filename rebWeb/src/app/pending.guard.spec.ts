import { TestBed, async, inject } from '@angular/core/testing';

import { PendingGuard } from './pending.guard';

describe('PendingGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PendingGuard]
    });
  });

  it('should ...', inject([PendingGuard], (guard: PendingGuard) => {
    expect(guard).toBeTruthy();
  }));
});
