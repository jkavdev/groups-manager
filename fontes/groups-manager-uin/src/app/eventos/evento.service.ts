import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import * as moment from 'moment';

import {EventoFilter} from '../core/filters';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  eventosUrl: string;

  constructor(private http: Http) {
    this.eventosUrl = `${environment.apiUrl}/eventos`;
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

  buscarPor(id: number) {
    return this.http.get(`${this.eventosUrl}/${id}`)
      .toPromise()
      .then(resp => {
        const evento = resp.json();
        this.converterStringsParaDatas(evento);
        this.converterUF(evento.endereco);
        return evento;
      });
  }

  private converterStringsParaDatas(evento: any) {
    evento.data = moment(evento.data, 'YYYY-MM-DD h:mm:ss').toDate();
  }

  private converterUF(endereco: any) {
    endereco.uf = endereco.uf.sigla;
  }

  atualizar(evento: any) {
    return this.http.put(`${this.eventosUrl}/${evento.id}`, evento)
      .toPromise()
      .then(resp => resp.json());
  }
}
