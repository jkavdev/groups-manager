import {Component, OnInit} from '@angular/core';

import {MessageService} from 'primeng/api';
import {IntegranteService} from '../integrante.service';

import {IntegranteFilter} from '../../core/filters';
import {ErrorHandlerService} from '../../core/error-handler.service';

@Component({
  selector: 'app-integrantes-pesquisa',
  templateUrl: './integrantes-pesquisa.component.html',
  styleUrls: ['./integrantes-pesquisa.component.css'],
  providers: [MessageService, ErrorHandlerService]
})
export class IntegrantesPesquisaComponent implements OnInit {

  filtro = new IntegranteFilter();
  integrantes = [];
  grupos = [];
  display = false;

  constructor(private integranteService: IntegranteService,
              private msgService: MessageService,
              private errorhandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.pesquisarIntegrantes();
  }

  pesquisarIntegrantes() {
    this.integranteService.pesquisar(this.filtro)
      .then(integrantes => {
        this.integrantes = integrantes;
        this.msgService.add({severity: 'info', summary: `Sucesso!`, detail: `Busca realizada!`});
      })
      .catch(erro => this.msgService.add({severity: 'error', summary: erro, detail: 'Erro ao realizar busca!'}));
  }

  exibirGrupos(idIntegrante: number) {
    this.integranteService.buscarGrupos(idIntegrante)
      .then(grupos => {
        this.grupos = grupos;
        this.display = true;
      })
      .catch(error => this.errorhandler.handle(error));
  }

}
