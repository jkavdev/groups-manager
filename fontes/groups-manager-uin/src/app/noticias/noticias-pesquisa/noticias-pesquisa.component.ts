import {Component, OnInit} from '@angular/core';

import {NoticiaService} from '../noticia.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

@Component({
  selector: 'app-noticias-pesquisa',
  templateUrl: './noticias-pesquisa.component.html',
  styleUrls: ['./noticias-pesquisa.component.css']
})
export class NoticiasPesquisaComponent implements OnInit {

  noticias = [];

  constructor(
    private noticiaService: NoticiaService,
    private errorHander: ErrorHandlerService
  ) {
  }

  ngOnInit() {
    this.buscar();
  }

  buscar() {
    this.noticiaService.grupoComNoticas()
      .then(noticias => this.noticias = noticias);
  }

  marcarComoUtil(id: number) {
    this.noticiaService.marcar(true, id)
      .then(() => {
      })
      .catch(erro => this.errorHander.handle(erro));
  }

  marcarComoNaoUtil(id: number) {
    this.noticiaService.marcar(false, id)
      .then(() => {
      })
      .catch(erro => this.errorHander.handle(erro));
  }

}
