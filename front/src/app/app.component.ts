import {Component} from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  menuBar: MenuItem[] = [
    {label: 'Mes examens et vaccins', icon: 'pi pi-calendar', routerLink: ['/home']},
  ];
}
