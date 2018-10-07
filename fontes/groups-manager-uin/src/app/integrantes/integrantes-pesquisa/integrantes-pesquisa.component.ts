import {Component, OnInit} from '@angular/core';

import {ConfirmationService, MessageService} from 'primeng/api';
import {IntegranteService} from '../integrante.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

import {IntegranteFilter} from '../../core/filters';

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
              private confirmation: ConfirmationService,
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
      .catch(error => this.errorhandler.handle(error));
  }

  limpar() {
    this.filtro = new IntegranteFilter();
  }

  remover(integrante: any) {
    this.confirmation.confirm({
      message: `Deseja remover o Integrante ${integrante.nome}?`,
      accept: () => {
        this.integranteService.remover(integrante.id)
          .then(() => {
            this.removerDataLista(integrante);
            this.msgService.add({severity: 'info', summary: `Sucesso!`, detail: `Integrante ${integrante.nome} removido!`});
          })
          .catch(error => this.errorhandler.handle(error));
      }
    });
  }

  private removerDataLista(integrante: any) {
    const index: number = this.integrantes.indexOf(integrante, 0);
    if (index !== -1) {
      this.integrantes.splice(index, 1);
    }
  }
}
