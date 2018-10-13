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

  todosGrupos() {
    return this.pesquisar(new GrupoFilter());
  }

  gruposComIntegrantes() {
    return this.http.get(`${this.gruposUrl}/gruposComIntegrantes`)
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

  atualizar(grupo: any) {
    return this.http.put(`${this.gruposUrl}/${grupo.id}`, grupo)
      .toPromise()
      .then(resp => resp.json());
  }

  comEventos(id: number): Promise<any> {
    return this.http.get(`${this.gruposUrl}/${id}/eventos`)
      .toPromise()
      .then(resp => resp.json());
  }

  comIntegrantes(id: number) {
    return this.http.get(`${this.gruposUrl}/${id}/integrantes`)
      .toPromise()
      .then(resp => resp.json());
  }

  remover(id: number) {
    return this.http.delete(`${this.gruposUrl}/${id}`)
      .toPromise()
      .then(resp => resp.json());
  }

  buscarPor(id: number) {
    return this.http.get(`${this.gruposUrl}/${id}`)
      .toPromise()
      .then(resp => resp.json());
  }
}
