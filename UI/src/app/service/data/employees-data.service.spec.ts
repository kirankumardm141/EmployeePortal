import { TestBed } from '@angular/core/testing';

import { EmployeesDataService } from './employees-data.service';

describe('EmployeesDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EmployeesDataService = TestBed.get(EmployeesDataService);
    expect(service).toBeTruthy();
  });
});
