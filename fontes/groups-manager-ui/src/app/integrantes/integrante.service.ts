import { Injectable } from '@angular/core';
import { Http, URLSearchParams } from '@angular/http';

import 'rxjs/add/operator/toPromise';

export class IntegranteFiltro {
  nome: string;
  grupo: string;
  de: Date;
  ate: Date;
}

@Injectable()
export class IntegranteService {

  integrantesUrl = 'http://localhost:8086/integrantes';

  constructor(private http: Http) { }

  pesquisar(filtro: IntegranteFiltro): Promise<any> {
    const params = new URLSearchParams();

    if (filtro.nome) {
      params.set('nome', filtro.nome);
    }
    if (filtro.grupo) {
      params.set('grupo', filtro.grupo);
    }

    return this.http.get(`${this.integrantesUrl}?pesquisa`, { search: filtro })
      .toPromise()
      .then(resp => resp.json());
  }

  efetivar(id: any): Promise<any> {
    return this.http.put(`${this.integrantesUrl}/${id}/efetivar`, true)
      .toPromise()
      .then(resp => resp.json());
  }

  validar(cpf: string) {
    return this.http.post(`${this.integrantesUrl}/validarcpf`, {"cpf": `${cpf}`})
      .toPromise()
      .then();
  }

}
