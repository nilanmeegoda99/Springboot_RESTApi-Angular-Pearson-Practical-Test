import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  //base URL of the REST Api
  private baseUrl = "http://127.0.0.1:8080/rest/v2/patients"

  constructor(private http: HttpClient) { }

  //calling the GET method 
  
  getPatients(): Observable<Patient[]>{
    return this.http.get<Patient[]>(`${this.baseUrl}`);
  }
}
