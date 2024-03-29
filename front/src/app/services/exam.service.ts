import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';
import { ExamListItem } from '../data/exam';

@Injectable({
  providedIn: 'root'
})
export class ExamService {
  

  private url : string = apiUrl + 'exams';

  constructor(private http : HttpClient) { }

  public getPagedExams(page : number, pageSize : number, sorting : string = "") : Observable<ExamListItem[]> {
    let sortString = "";
    if (sorting != "") {
      sortString = "&filter=" + sorting;
    }
    return this.http.get<ExamListItem[]>(this.url + "/list/paginated?page=" + page + "&size=" + pageSize + sortString);
  }

  public getAges() :Observable<string[]> {
    return this.http.get<string[]>(this.url + "/ages");
  }

  public getCountries() :Observable<string[]> {
    return this.http.get<string[]>(this.url + "/countries");
  }

  public getRecommendations() :Observable<string[]> {
    return this.http.get<string[]>(this.url + "/recommendations");
  }
}
