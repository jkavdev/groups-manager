import {Component, OnInit} from '@angular/core';

import {EventoService} from '../evento.service';
import {EventoFilter} from '../../core/filters';
import {MessageService} from 'primeng/api';
import {ErrorHandlerService} from '../../core/error-handler.service';

import {Evento} from '../../core/model';

@Component({
  selector: 'app-eventos-pesquisa',
  templateUrl: './eventos-pesquisa.component.html',
  styleUrls: ['./eventos-pesquisa.component.css'],
  providers: [MessageService, ErrorHandlerService]
})
export class EventosPesquisaComponent implements OnInit {

  filtro = new EventoFilter();
  eventos = [];
  pt: any;
  evento = new Evento();
  display = false;

  constructor(private eventoService: EventoService,
              private msgService: MessageService,
              private errorhandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.pt = {
      firstDayOfWeek: 0,
      dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
      dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
      dayNamesMin: ['Do', 'Se', 'Te', 'Qu', 'Qu', 'Se', 'Sa'],
      monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
      monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
      today: 'Hoje',
      clear: 'Limpar'
    };
    this.pesquisarEventos();
  }

  pesquisarEventos() {
    this.eventoService.pesquisar(this.filtro)
      .then(eventos => {
        this.eventos = eventos;
        this.msgService.add({severity: 'info', summary: `Sucesso!`, detail: `Busca realizada!`});
      })
      .catch(error => this.errorhandler.handle(error));
  }

  exibirEvento(evento: any) {
    this.evento = evento;
    this.display = true;
  }

}
