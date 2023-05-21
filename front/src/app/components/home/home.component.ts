import { Component, HostListener } from '@angular/core';
import { ExamListItem } from '../../data/exam';
import { ExamService } from 'src/app/services/exam.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  private static readonly PAGE_SIZE : number = 12;

  examList : ExamListItem[] = [
    {
      id: "1",
      name: "Examen de la prostate",
      description: "Cet examen permet de détecter le cancer de la prostate"
    },
    {
      id: "2",
      name: "Examen de la vésicule biliaire",
      description: "Cet examen permet de détecter le cancer de la vésicule biliaire"
    }
  ];

  page : number = 0;
  hasElementsLeft : boolean = true;

  sortRating : any[] = [
    { label: 'Note croissante', value: 'asc' },
    { label: 'Note décroissante', value: 'desc' }
  ];

  sorting : FormGroup = new FormGroup({ rating: new FormControl() });

  constructor(private examService : ExamService) { }

  ngOnInit(): void {
    this.loadMoreExams();

    this.sorting.valueChanges.subscribe(data => {
      this.page = 0;
      this.hasElementsLeft = true;
      this.examList = [];
      this.loadMoreExams();
    });
  }

  loadMoreExams() {
    if(this.hasElementsLeft){
      this.examList.push(...Array(HomeComponent.PAGE_SIZE));

      let sortingStr = "";

      if(this.sorting.value.rating != null) {
        sortingStr = "rating," + this.sorting.value.rating.value;
      }

      this.examService.getPagedExams(this.page, HomeComponent.PAGE_SIZE, sortingStr).subscribe(
        (data) => {
          for(let i = 0; i < data.length; i++) {
            this.examList[this.page * HomeComponent.PAGE_SIZE + i] = data[i];
          }

          if(data.length < HomeComponent.PAGE_SIZE) {
            let diff = HomeComponent.PAGE_SIZE - data.length;
            
            //Remvove the skeletons
            this.examList.splice(this.page * HomeComponent.PAGE_SIZE + data.length, diff);
            
            this.hasElementsLeft = false;
          }
          ++this.page;
        }
      );
    }
  }

  //Event for end of page
  @HostListener('window:scroll', ['$event'])
  onScroll(event: any) {
    if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
      this.loadMoreExams();
    }
  }

}
