import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

import {GrupoService} from '../grupo.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

import {Grupo} from '../../core/model';

@Component({
  selector: 'app-grupos-eventos',
  templateUrl: './grupos-eventos.component.html',
  styleUrls: ['./grupos-eventos.component.css']
})
export class GruposEventosComponent implements OnInit {

  grupo: Grupo = new Grupo();

  events: any[] = [];
  header: any;

  constructor(
    private route: ActivatedRoute,
    private grupoService: GrupoService,
    private errorHandler: ErrorHandlerService,
  ) {
  }

  ngOnInit() {
    const idGrupo = this.route.snapshot.params['id'];

    if (idGrupo) {
      this.buscarGrupo(idGrupo);
    }
  }

  buscarGrupo(codigo: number) {
    this.grupoService.comEventos(codigo)
      .then(grupo => {
        this.grupo = grupo;
        this.preencherDados(this.grupo.eventos);
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  preencherDados(eventos: any[]) {
    eventos.forEach(e => this.events.push({'title': e.descricao, 'start': e.data}));
    this.header = {
      left: 'prev,next',
      center: 'title',
      right: 'month,agendaWeek,agendaDay'
    };
  }

}
