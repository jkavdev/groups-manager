import {Injectable} from '@angular/core';
import {Http, URLSearchParams} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Grupo, StatusGrupo} from '../core/model';

export class GrupoFiltro {
  nome: string;
}

export interface GrupoSummary {
  id;
  nome;
  status: StatusGrupo
  objetivo;
  igreja;
}

@Injectable()
export class GrupoService {

  gruposUrl = 'http://localhost:8086/grupos';

  constructor(private http: Http) {
  }

  pesquisar(filtro: GrupoFiltro): Promise<any> {
    const params = new URLSearchParams();

    if (filtro.nome) {
      params.set('nome', filtro.nome);
    }

    return this.http.get(`${this.gruposUrl}?pesquisa`, {search: filtro})
      .toPromise()
      .then(resp => <GrupoSummary[]> resp.json());
  }

  excluir(codigo: number): Promise<any> {
    return this.http.delete(`${this.gruposUrl}/${codigo}`)
      .toPromise()
      .then(() => null)
  }

  todosStatus(): Promise<any> {
    return this.http.get(`${this.gruposUrl}/status`)
      .toPromise()
      .then(resp => resp.json());
  }

  comEventos(id: number): Promise<any> {
    return this.http.get(`${this.gruposUrl}/${id}/eventos`)
      .toPromise()
      .then(resp => resp.json());
  }

  salvar(grupo: Grupo): Promise<any> {
    return this.http.post(`${this.gruposUrl}`, grupo)
      .toPromise()
      .then(resp => resp.json());
  }

}
