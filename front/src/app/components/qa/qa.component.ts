import {Component} from '@angular/core';
import {qa} from "../../data/qa";

@Component({
  selector: 'app-qa',
  templateUrl: './qa.component.html',
  styleUrls: ['./qa.component.scss']
})
export class QAComponent {
  questions: qa[] = [
    {
      id: '1',
      question: 'Comment nous soutenir ?',
      answers: ['Vous pouvez nous soutenir en faisant un don sur notre page de collecte : paypal.me/argent',],
      isExpanded: false
    },
    {
      id: '2',
      question: 'Une information est fausse, que faire ?',
      answers: ['Vous pouvez nous la signaler en passant par le bouton signaler en dessous de celle-ci. En étroite collaboration avec des scientifiques de toute la France nous prendrons le soin de vous répondre sous 48 heures.',],
      isExpanded: false
    },
    // add as many questions as you want here
  ];
}
