import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

@Injectable()
export class NoticiaService {

  noticiasUrl = 'http://localhost:8086/noticias';

  constructor(private http: Http) {
  }

  adicionar(noticia: any): Promise<any> {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.post(`${this.noticiasUrl}`,
      JSON.stringify(noticia), {headers})
      .toPromise()
      .then(resp => resp.json());
  }

  buscarTodas(): Promise<any> {
    return this.http.get(`${this.noticiasUrl}`)
      .toPromise()
      .then(resp => resp.json());
  }

  grupoComNoticas(): Promise<any> {
    return this.http.get(`${this.noticiasUrl}/agrupadas`)
      .toPromise()
      .then(resp => resp.json());
  }

  marcar(util: boolean, id: number): Promise<any> {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put(`${this.noticiasUrl}/${id}/marcar`, util, {headers})
      .toPromise()
      .then(resp => resp.json());
  }

}
