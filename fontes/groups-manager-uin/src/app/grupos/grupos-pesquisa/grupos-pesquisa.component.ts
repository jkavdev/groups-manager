import {Component, OnInit} from '@angular/core';

import {GrupoService} from '../grupo.service';
import {GrupoFilter} from '../../core/filters';

@Component({
  selector: 'app-grupos-pesquisa',
  templateUrl: './grupos-pesquisa.component.html',
  styleUrls: ['./grupos-pesquisa.component.css']
})
export class GruposPesquisaComponent implements OnInit {

  grupos = [];
  filtro = new GrupoFilter();

  constructor(private grupoService: GrupoService) {
  }

  pesquisarGrupos() {
    this.grupoService.pesquisar(this.filtro)
      .then(resp => this.grupos = resp)
      .catch(error => console.log(error));
  }

  ngOnInit() {
    this.pesquisarGrupos();
  }

}
