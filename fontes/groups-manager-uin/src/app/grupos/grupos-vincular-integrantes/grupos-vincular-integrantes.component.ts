import {Component, OnInit} from '@angular/core';
import {GrupoService} from '../grupo.service';
import {ErrorHandlerService} from '../../core/error-handler.service';
import {MessageService} from 'primeng/api';
import {IntegranteService} from '../../integrantes/integrante.service';
import {Grupo, Integrante} from '../../core/model';

@Component({
  selector: 'app-grupos-vincular-integrantes',
  templateUrl: './grupos-vincular-integrantes.component.html',
  styleUrls: ['./grupos-vincular-integrantes.component.css'],
  providers: [MessageService, ErrorHandlerService]
})
export class GruposVincularIntegrantesComponent implements OnInit {

  grupos: Grupo[] = [];
  grupoSelecionado = new Grupo();
  integrantes: Integrante[] = [];
  integrantesSelecionados: Integrante[] = [];
  vincular = true;

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
        // this.grupos.push({label: 'Selecione um Grupo', value: null});
        // grupos.forEach(grupo => this.grupos.push({label: grupo.nome, value: grupo}));
        this.grupos = grupos;
      }).catch(error => this.errorhandler.handle(error));
  }

  buscarIntegrantes() {
    this.integranteService.todosIntegrantes()
      .then(integrantes => {
        this.integrantes = integrantes;
      }).catch(error => this.errorhandler.handle(error));
  }

  atualizarIntegrantesSelecionados() {
    if (this.grupoSelecionado) {
      const integrantesGrupo = this.grupoSelecionado.integrantes.map(value => JSON.stringify(value));
      this.vincular = false;
      this.integrantes =
        this.integrantes.filter(value => !integrantesGrupo.includes(JSON.stringify(value)));
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
