import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';
import {environment} from '../../environments/environment';
import * as moment from 'moment';

@Injectable({
  providedIn: 'root'
})
export class NoticiaService {

  noticiasUrl: string;

  constructor(private http: Http) {
    this.noticiasUrl = `${environment.apiUrl}/noticias`;
  }

  adicionar(noticia: any): Promise<any> {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.post(`${this.noticiasUrl}`,
      JSON.stringify(noticia), {headers})
      .toPromise()
      .then(resp => {

        const noticiaSalva = resp.json();

        this.converterTopicos(noticiaSalva);

        return noticiaSalva;
      });
  }

  private converterTopicos(noticia: any) {
    noticia.topicos = noticia.topicos.map(topico => topico.topico);
  }

  atualizar(noticia: any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.put(`${this.noticiasUrl}`,
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
