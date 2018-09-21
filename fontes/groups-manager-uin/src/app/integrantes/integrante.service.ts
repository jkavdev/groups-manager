import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {IntegranteFilter} from '../core/filters';

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

  pesquisar(filtro: IntegranteFilter): Promise<any> {
    return this.http.get(`${this.integrantesUrl}?pesquisa`, {search: filtro})
      .toPromise()
      .then(resp => resp.json());
  }

}

