import { Component, OnInit } from '@angular/core';

import { ToastyService } from 'ng2-toasty';

import { NoticiaService } from '../noticia.service';
import { ErrorHandlerService } from '../../core/error-handler.service';

@Component({
  selector: 'app-noticia-pesquisa',
  templateUrl: './noticia-pesquisa.component.html',
  styleUrls: ['./noticia-pesquisa.component.css']
})
export class NoticiaPesquisaComponent implements OnInit {

  noticias = [];

  constructor(
    private noticiaService: NoticiaService,
    private errorHander: ErrorHandlerService,
    private toasty: ToastyService
  ) { }

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
        this.toasty.success('Notícia marcada como útil')
      })
      .catch(erro => this.errorHander.handle(erro));
  }
  marcarComoNaoUtil(id: number) {
    this.noticiaService.marcar(false, id)
      .then(() => {
        this.toasty.success('Notícia marcada não como útil')
      })
      .catch(erro => this.errorHander.handle(erro));
  }

}
