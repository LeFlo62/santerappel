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

  private static readonly PAGE_SIZE : number = 10;

  examList : ExamListItem[] = [];

  page : number = 0;
  hasElementsLeft : boolean = true;

  ages : any[] = [
   "1 mois",
   "2 mois",
   "2-7 mois",
   "4 mois",
   "5 mois",
   "11 mois",
   "12 mois",
   "16-18 mois",
   "18 mois",
   "5 ans",
   "6 ans",
   "11-13 ans",
   "14 ans",
   "65 ans"
  ];

  isVaccine : any[] = [
    { label: 'Oui', value: true },
    { label: 'Non', value: false }
  ];

  filters : FormGroup = new FormGroup({ age: new FormControl(), vaccine : new FormControl() });

  constructor(private examService : ExamService) { }

  ngOnInit(): void {
    this.loadMoreExams();

    this.filters.valueChanges.subscribe(data => {
      this.page = 0;
      this.hasElementsLeft = true;
      this.examList = [];
      this.loadMoreExams();
    });
  }

  loadMoreExams() {
    if(this.hasElementsLeft){
      this.examList.push(...Array(HomeComponent.PAGE_SIZE));

      let filterStr = "";

      if(this.filters.value.age != null) {
        filterStr += "age:" + this.filters.value.age.join(",age:");
      }

      if(this.filters.value.vaccine != null) {
        filterStr += "isVaccine:" + this.filters.value.vaccine.value;
      }

      this.examService.getPagedExams(this.page, HomeComponent.PAGE_SIZE, filterStr).subscribe(
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
