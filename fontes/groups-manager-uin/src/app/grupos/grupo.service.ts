import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

export class GrupoFilter {
  nome: string;
}

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
}
