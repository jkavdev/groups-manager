import { Component, OnInit } from '@angular/core';

import { EventoService } from '../evento.service';
import { ToastyService } from 'ng2-toasty';
import { ErrorHandlerService } from '../../core/error-handler.service';

export class EventoFiltro {
  de: Date;
  ate: Date;
}

@Component({
  selector: 'app-evento-pesquisa',
  templateUrl: './evento-pesquisa.component.html',
  styleUrls: ['./evento-pesquisa.component.css']
})
export class EventoPesquisaComponent implements OnInit {

  eventoFiltro = new EventoFiltro();
  eventos = [];

  constructor(
    private eventoService: EventoService,
    private toasty: ToastyService,
    private errorHandler: ErrorHandlerService
  ) { }

  ngOnInit() {
    this.pesquisar();
  }

  pesquisar() {
    this.eventoService.pesquisar(this.eventoFiltro)
      .then(eventos => {
        this.eventos = eventos;
        this.toasty.success('Consulta realizada!')
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

}
