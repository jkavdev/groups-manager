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
  dados = [];

  constructor(
    private integranteService: IntegranteService
  ) {
  }

  ngOnInit() {
    this.pesquisar();
    console.log(this.dados);
  }

  pesquisar() {
    this.integranteService.pesquisar(this.filtro)
      .then(integrantes => this.dados = integrantes);
  }

}
