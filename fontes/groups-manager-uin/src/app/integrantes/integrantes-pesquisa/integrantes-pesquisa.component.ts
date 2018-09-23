import {Component, OnInit} from '@angular/core';

import {MessageService} from 'primeng/api';
import {IntegranteService} from '../integrante.service';

import {IntegranteFilter} from '../../core/filters';

@Component({
  selector: 'app-integrantes-pesquisa',
  templateUrl: './integrantes-pesquisa.component.html',
  styleUrls: ['./integrantes-pesquisa.component.css'],
  providers: [MessageService]
})
export class IntegrantesPesquisaComponent implements OnInit {

  filtro = new IntegranteFilter();
  integrantes = [];

  constructor(private integranteService: IntegranteService,
              private msgService: MessageService) {
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

}
