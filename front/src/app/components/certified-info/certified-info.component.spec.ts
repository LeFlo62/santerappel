import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CertifiedInfoComponent } from './certified-info.component';

describe('CertifiedInfoComponent', () => {
  let component: CertifiedInfoComponent;
  let fixture: ComponentFixture<CertifiedInfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CertifiedInfoComponent]
    });
    fixture = TestBed.createComponent(CertifiedInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
