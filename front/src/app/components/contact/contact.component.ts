import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {
  contactForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.contactForm = this.fb.group({
      firstname: ['', [Validators.pattern('^[a-zA-Z ]*$')]],
      lastname: ['', [Validators.pattern('^[a-zA-Z ]*$')]],
      phone: ['', [Validators.required, Validators.pattern('^0[6-7][0-9]{8}$')]],
      content: ['', [Validators.required, Validators.maxLength(100)]],
      subject: ['', [Validators.required, Validators.maxLength(300)]]
    });
  }

  onSubmit() {
    if (
      (this.contactForm.controls['firstname'].invalid && this.contactForm.controls['firstname'].dirty) ||
      (this.contactForm.controls['lastname'].invalid && this.contactForm.controls['lastname'].dirty) ||
      (this.contactForm.controls['phone'].invalid && this.contactForm.controls['phone'].dirty) ||
      (this.contactForm.controls['content'].invalid && this.contactForm.controls['content'].dirty) ||
      (this.contactForm.controls['subject'].invalid && this.contactForm.controls['subject'].dirty)
    ) {
      alert('Veillez remplir tous les champs correctement');
    } else {
      const mailtoLink = `mailto:someone@example.com?subject=${this.contactForm.value.subject}&body=Name: ${this.contactForm.value.firstname} ${this.contactForm.value.lastname}%0D%0APhone: ${this.contactForm.value.phone}%0D%0AMessage: ${this.contactForm.value.content}`;
      window.location.href = mailtoLink;
    }
  }
}
