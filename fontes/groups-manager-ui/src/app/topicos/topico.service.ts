import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable()
export class TopicoService {

  topicosUrl = 'http://localhost:8086/noticias/topicos';

  constructor(private http: Http) { }

  pesquisar(): Promise<any> {
    return this.http.get(`${this.topicosUrl}`)
      .toPromise()
      .then(resp => resp.json());
  }

}
