import {Component, OnInit} from '@angular/core';

import {IntegranteService} from '../integrante.service';

import {IntegranteFilter} from '../../core/filters';

@Component({
  selector: 'app-integrantes-pesquisa',
  templateUrl: './integrantes-pesquisa.component.html',
  styleUrls: ['./integrantes-pesquisa.component.css']
})
export class IntegrantesPesquisaComponent implements OnInit {

  filtro = new IntegranteFilter();
  integrantes = [];

  constructor(private integranteService: IntegranteService) {
  }

  ngOnInit() {
    this.pesquisarIntegrantes();
  }

  pesquisarIntegrantes() {
    this.integranteService.pesquisar(this.filtro)
      .then(integrantes => this.integrantes = integrantes);
  }

}
