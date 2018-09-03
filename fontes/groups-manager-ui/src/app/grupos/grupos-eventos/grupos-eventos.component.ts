import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {GrupoService} from "../grupo.service";
import {Grupo} from "../../core/model";
import {ToastyService} from "ng2-toasty";
import {ErrorHandlerService} from "../../core/error-handler.service";

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
    private grupoService: GrupoService,
    private route: ActivatedRoute,
    private router: Router,
    private toasty: ToastyService,
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
    eventos.forEach(e => this.events.push({"title": e.descricao, "start": e.data}));
    this.header = {
      left: 'prev,next',
      center: 'title',
      right: 'month,agendaWeek,agendaDay'
    };
  }

}
