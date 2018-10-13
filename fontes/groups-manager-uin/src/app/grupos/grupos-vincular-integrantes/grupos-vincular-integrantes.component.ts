import {Component, OnInit} from '@angular/core';

import {MessageService} from 'primeng/api';
import {GrupoService} from '../grupo.service';
import {ErrorHandlerService} from '../../core/error-handler.service';
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
  integrantesGrupo: Integrante[] = [];
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
      .then(grupos => this.grupos = grupos)
      .catch(error => this.errorhandler.handle(error));
  }

  buscarIntegrantes() {
    this.integranteService.todosIntegrantes()
      .then(integrantes => this.integrantes = integrantes)
      .catch(error => this.errorhandler.handle(error));
  }

  atualizarIntegrantesSelecionados() {
    if (this.grupoSelecionado) {
      this.vincular = false;
      const integrantesGrupo = this.grupoSelecionado.integrantes.map(value => JSON.stringify(value));
      this.integrantes =
        this.integrantes.filter(value => !integrantesGrupo.includes(JSON.stringify(value)));
      this.integrantesGrupo = JSON.parse(JSON.stringify(this.grupoSelecionado.integrantes));
    }
  }

  salvarAlteracoes() {
    this.grupoService.vincularIntegrantes(this.grupoSelecionado.id, this.grupoSelecionado.integrantes)
      .then(() => {
        this.msgService.add({severity: 'info', summary: `Sucesso!`, detail: `Dados salvos com sucesso!`});
        this.integrantesGrupo = JSON.parse(JSON.stringify(this.grupoSelecionado.integrantes));
      }).catch(error => this.errorhandler.handle(error));
  }

  limpar() {
    this.buscarGrupos();
    this.buscarIntegrantes();
    this.grupoSelecionado = new Grupo();
    this.integrantesGrupo = [];
  }

}
