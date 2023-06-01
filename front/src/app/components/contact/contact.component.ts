import { Component } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent {
  firstname = '';
  lastname = '';
  phone = '';
  subject = '';
  content = '';

  onSubmit() {
    if (!this.firstname || !this.lastname || !this.phone || !this.subject || !this.content) {
      alert('Veilliez remplir tous les champs');
    } else if (this.content.length > 100) {
      alert('Le contenu ne peut pas dépasser 100 caractères');
    } else {
      const mailtoLink = `mailto:someone@example.com?subject=${this.subject}&body=Name: ${this.firstname} ${this.lastname}%0D%0APhone: ${this.phone}%0D%0AMessage: ${this.content}`;
      window.location.href = mailtoLink;
    }
  }

}
