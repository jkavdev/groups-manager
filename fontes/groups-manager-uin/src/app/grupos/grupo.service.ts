import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Grupo} from '../core/model';
import {GrupoFilter} from '../core/filters';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  gruposUrl: string;

  constructor(private http: Http) {
    this.gruposUrl = `${environment.apiUrl}/grupos`;
  }

  pesquisar(filtro: GrupoFilter): Promise<any> {
    const params = new URLSearchParams();

    if (filtro.nome) {
      params.set('nome', filtro.nome);
    }

    return this.http.get(`${this.gruposUrl}?pesquisa`, {search: filtro})
      .toPromise()
      .then(resp => resp.json());
  }

  todosStatusGrupos(): Promise<any> {
    return this.http.get(`${this.gruposUrl}/status`)
      .toPromise()
      .then(resp => resp.json());
  }

  salvar(grupo: Grupo): Promise<any> {
    return this.http.post(`${this.gruposUrl}`, grupo)
      .toPromise()
      .then(resp => resp.json());
  }

  comEventos(id: number): Promise<any> {
    return this.http.get(`${this.gruposUrl}/${id}/eventos`)
      .toPromise()
      .then(resp => resp.json());
  }
}
