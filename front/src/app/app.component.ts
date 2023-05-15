import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  
  menuBar : MenuItem[] = [
    {label: 'Accueil', icon: 'pi pi-fw pi-home', routerLink: ['/home']},
  ];
  
}
