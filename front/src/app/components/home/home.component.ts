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

  display = false;

  examList : ExamListItem[] = [];

  page : number = 0;
  hasElementsLeft : boolean = true;

  ages : any[] = [];
  countries : any[] = [];
  recommendations : any[] = [];

  isVaccine : any[] = [
    { label: 'Oui', value: true },
    { label: 'Non', value: false }
  ];

  sex : any[] = [
    { label: 'Homme', value: 'M' },
    { label: 'Femme', value: 'F' }
  ];

  filters : FormGroup = new FormGroup({
    age: new FormControl(),
    vaccine : new FormControl(),
    countries : new FormControl(),
    recommendation : new FormControl(),
    sex : new FormControl(),
  });

  constructor(private examService : ExamService) { }

  ngOnInit(): void {
    this.loadFilters();

    this.loadMoreExams();

    this.filters.valueChanges.subscribe(data => {
      this.page = 0;
      this.hasElementsLeft = true;
      this.examList = [];
      this.loadMoreExams();
    });
  }

  loadFilters() {
    this.examService.getAges().subscribe((data : string[]) => {
      console.log(data);
      console.log(data.map(s => parseInt(s)));
      this.ages = Array.from(new Set(data.map(s => parseInt(s)))).map((age : number) => { return { label: (age % 12 != 0 ? age + ' mois' : (age / 12) + ' ans'), value: age } }).sort((a, b) => a.value - b.value);
    });

    this.examService.getCountries().subscribe((data : string[]) => {
      this.countries = data.map((country : string) => { return { label: country, value: country } });
    });

    this.examService.getRecommendations().subscribe((data : any[]) => {
      this.recommendations = data;
    });
  }

  loadMoreExams() {
    if(this.hasElementsLeft){
      this.examList.push(...Array(HomeComponent.PAGE_SIZE));

      let filterStr = "";

      if(this.filters.value.age != null && this.filters.value.age.length > 0) {
        filterStr += "age:" + this.filters.value.age.join(",age:");
      }

      if(this.filters.value.recommendation != null && this.filters.value.recommendation.length > 0) {
        filterStr += "recommendation:" + this.filters.value.recommendation.join(",recommendation:");
      }

      if(this.filters.value.sex != null && this.filters.value.sex.length > 0) {
        filterStr += "sex:" + this.filters.value.sex.join(",sex:");
      }

      if(this.filters.value.vaccine != null) {
        filterStr += "isVaccine:" + this.filters.value.vaccine.value;
      }

      if(this.filters.value.countries != null && this.filters.value.countries.length > 0) {
        filterStr += "countryList:" + this.filters.value.countries.join(",countryList:");
      }

      this.examService.getPagedExams(this.page, HomeComponent.PAGE_SIZE, filterStr).subscribe((data : ExamListItem[]) => {
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
