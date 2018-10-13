import {Component, OnInit} from '@angular/core';
import {GrupoService} from '../grupo.service';
import {ErrorHandlerService} from '../../core/error-handler.service';
import {MessageService} from 'primeng/api';
import {IntegranteService} from '../../integrantes/integrante.service';

@Component({
  selector: 'app-grupos-vincular-integrantes',
  templateUrl: './grupos-vincular-integrantes.component.html',
  styleUrls: ['./grupos-vincular-integrantes.component.css'],
  providers: [MessageService, ErrorHandlerService]
})
export class GruposVincularIntegrantesComponent implements OnInit {

  grupos: any = [];
  grupoSelecionado: any;
  integrantes: any = [];
  integrantesSelecionados: any = [];

  constructor(
    private grupoService: GrupoService,
    private integranteService: IntegranteService,
    private errorhandler: ErrorHandlerService,
    private msgService: MessageService,
  ) {
  }

  ngOnInit() {
    this.buscarGrupos();
    this.buscarIntegrantes();
  }

  buscarGrupos() {
    this.grupoService.gruposComIntegrantes()
      .then(grupos => {
        this.grupos = [];
        this.grupos.push({label: 'Selecione um Grupo', value: null});
        grupos.forEach(grupo => this.grupos.push({label: grupo.nome, value: grupo}));
      }).catch(error => this.errorhandler.handle(error));
  }

  buscarIntegrantes() {
    this.integranteService.todosIntegrantes()
      .then(integrantes => {
        this.integrantes = integrantes;
      }).catch(error => this.errorhandler.handle(error));
  }

  atualizarIntegrantesSelecionados() {
    if (this.integrantesSelecionados) {
      this.integrantesSelecionados = this.grupoSelecionado.integrantes;
    }
  }

  // atualizarIntegrantesSelecionados() {
  //   if (this.grupoSelecionado) {
  //     this.integrantesSelecionados = this.grupoSelecionado.integrantes;
  //   }{
  //     this.integrantesSelecionados = [];
  //   }
  // }

}
