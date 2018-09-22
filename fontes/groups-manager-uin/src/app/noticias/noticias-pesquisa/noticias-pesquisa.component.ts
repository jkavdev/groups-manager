import {Component, OnInit} from '@angular/core';

import {MessageService} from 'primeng/api';
import {NoticiaService} from '../noticia.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

@Component({
  selector: 'app-noticias-pesquisa',
  templateUrl: './noticias-pesquisa.component.html',
  styleUrls: ['./noticias-pesquisa.component.css'],
  providers: [MessageService]
})
export class NoticiasPesquisaComponent implements OnInit {

  noticias = [];

  constructor(
    private noticiaService: NoticiaService,
    private errorHander: ErrorHandlerService,
    private msgService: MessageService
  ) {
  }

  ngOnInit() {
    this.buscar();
  }

  buscar() {
    this.noticiaService.grupoComNoticas()
      .then(noticias => {
        this.noticias = noticias;
        this.msgService.add({severity: 'info', summary: `Sucesso!`, detail: `Buscada realizada!`});
      });
  }

  marcarComoUtil(id: number) {
    this.noticiaService.marcar(true, id)
      .then(() => this.msgService.add({severity: 'success', summary: `Sucesso!`, detail: `Notícia marcada como útil!`}))
      .catch(erro => this.errorHander.handle(erro));
  }

  marcarComoNaoUtil(id: number) {
    this.noticiaService.marcar(false, id)
      .then(() => this.msgService.add({severity: 'warn', summary: `Sucesso!`, detail: `Notícia marcada como não útil!`}))
      .catch(erro => this.errorHander.handle(erro));
  }

}
