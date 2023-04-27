import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {candidat} from "../Model/candidat";

@Injectable({
  providedIn: 'root'
})
export class CandidatService {
  readonly API_URL = 'http://localhost:8080/candidature';

  constructor(private httpClient: HttpClient) { }

  addCandidature(candidat:candidat){
    return this.httpClient.post(`${this.API_URL}/create`,candidat);
  }

  getAll() {
    return this.httpClient.get(`${this.API_URL}/all`)
  }

  delete(id: any) {
    return this.httpClient.delete(`${this.API_URL}/deletec/${id}`);
  }
}
