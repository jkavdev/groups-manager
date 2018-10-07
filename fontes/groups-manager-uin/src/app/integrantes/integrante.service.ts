import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {IntegranteFilter} from '../core/filters';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IntegranteService {

  integrantesUrl: string;

  constructor(private http: Http) {
    this.integrantesUrl = `${environment.apiUrl}/integrantes`;
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

  remover(id: number) {
    return this.http.delete(`${this.integrantesUrl}/${id}`)
      .toPromise()
      .then(() => null);
  }
}

