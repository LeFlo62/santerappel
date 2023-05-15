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

  public getPagedHousing(page : number, pageSize : number, sorting : string = "") : Observable<ExamListItem[]> {
    let sortString = "";
    if (sorting != "") {
      sortString = "&sort=" + sorting;
    }
    return this.http.get<ExamListItem[]>(this.url + "/list/paginated?page=" + page + "&size=" + pageSize + sortString);
  }
}
