import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { EventoFiltro } from './evento-pesquisa/evento-pesquisa.component';

@Injectable()
export class EventoService {

  eventosUrl = 'http://localhost:8086/eventos';

  constructor(private http: Http) { }

  salvar(evento: any): Promise<any> {
    return this.http.post(`${this.eventosUrl}`, evento)
      .toPromise()
      .then(resp => resp.json());
  }

  pesquisar(filtro: EventoFiltro): Promise<any> {
    let params = {
      'de': '',
      'ate': '',
    }
    if (filtro.de) {
      params.de = filtro.de.toLocaleString('pt-BR')
    }
    if (filtro.ate) {
      params.ate = filtro.ate.toLocaleString('pt-BR')
    }

    return this.http.get(`${this.eventosUrl}?pesquisa`, { search: params })
      .toPromise()
      .then(resp => resp.json());
  }

}
