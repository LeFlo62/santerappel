import {Component} from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent {
  quotes: String[] = ["La santé est notre bien le plus précieux, et ne devrait pas être ignorée. ", "Ensemble informons ceux qui nous tiennent à coeur."];
  healthNews = [
    {
      title: 'En 2022, la France compte toujours près de 12 millions de fumeurs quotidiens',
      date: '2023-06-02',
      content: 'Santé publique France publie dans le BEH n°9-10, les dernières estimations de la prévalence du tabagisme en France métropolitaine parmi les adultes de 18 à 75 ans.'
    },
    {
      title: 'Infections nosocomiales et traitements anti-infectieux en établissements de santé : résultats de l’enquête nationale de prévalence 2022',
      date: '2023-06-01',
      content: 'Publication des principaux résultats de l’enquête nationale de prévalence 2022 des infections nosocomiales et des traitements anti-infectieux en établissement de santé'
    },
    {
      title: 'Être bien informé pour préserver sa santé sexuelle, un enjeu de santé publique',
      date: '2023-06-01',
      content: '\'Santé publique France publie le communiqué de presse accompagnant la diffusion de la campagne de sensibilisation sur différentes thématiques de la santé sexuelle'
    },
  ];
}
