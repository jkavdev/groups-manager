import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {Grupo} from '../core/model';
import {GrupoFilter} from '../core/filters';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  gruposUrl = 'http://localhost:8086/grupos';

  constructor(private http: Http) {
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
}
