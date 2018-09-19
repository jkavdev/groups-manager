import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import {EventoFilter} from '../core/filters';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  eventosUrl = 'http://localhost:8086/eventos';

  constructor(private http: Http) {
  }

  pesquisar(filtro: EventoFilter): Promise<any> {
    const params = {
      'de': '',
      'ate': '',
    };
    if (filtro.de) {
      params.de = filtro.de;
    }
    if (filtro.ate) {
      params.ate = filtro.ate.toLocaleString('pt-BR');
    }

    return this.http.get(`${this.eventosUrl}?pesquisa`, {search: params})
      .toPromise()
      .then(resp => resp.json());
  }

  ufs(): Promise<any> {
    return this.http.get(`${this.eventosUrl}/ufs`)
      .toPromise()
      .then(resp => resp.json());
  }

  salvar(evento: any): Promise<any> {
    return this.http.post(`${this.eventosUrl}`, evento)
      .toPromise()
      .then(resp => resp.json());
  }
}
