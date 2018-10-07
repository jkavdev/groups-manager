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

  pesquisar(filtro: IntegranteFilter): Promise<any> {
    return this.http.get(`${this.integrantesUrl}?pesquisa`, {search: filtro})
      .toPromise()
      .then(resp => resp.json());
  }

  buscarPor(id: number) {
    return this.http.get(`${this.integrantesUrl}/${id}`)
      .toPromise()
      .then(resp => resp.json());
  }

  salvar(integrante: any): Promise<any> {
    return this.http.post(`${this.integrantesUrl}`, integrante)
      .toPromise()
      .then(resp => resp.json());
  }

  remover(id: number) {
    return this.http.delete(`${this.integrantesUrl}/${id}`)
      .toPromise()
      .then(() => null);
  }

  atualizar(integrante: any) {
    return this.http.put(`${this.integrantesUrl}/${integrante.id}`, integrante)
      .toPromise()
      .then(resp => resp.json());
  }

  buscarGrupos(idIntegrante: number) {
    return this.http.get(`${this.integrantesUrl}/${idIntegrante}/grupos`)
      .toPromise()
      .then(resp => resp.json());
  }
}

