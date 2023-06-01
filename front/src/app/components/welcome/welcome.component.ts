import {Component} from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent {
  quotes: String[] = ["La santé est notre bien le plus précieux, et ne devrait pas être ignorée. ", "Ensemble informons ceux qui nous tiennent à coeur."];
}
