import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class IntegranteService {

  integrantesUrl = 'http://localhost:8086/integrantes';

  constructor(private http: Http) {
  }

  salvar(integrante: any): Promise<any> {
    return this.http.post(`${this.integrantesUrl}`, integrante)
      .toPromise()
      .then(resp => resp.json());
  }

}

