import { Component, OnInit } from '@angular/core';

import { ToastyService } from 'ng2-toasty';
import { ConfirmationService } from 'primeng/components/common/api';

import { GrupoService, GrupoFiltro } from '../grupo.service';
import { ErrorHandlerService } from '../../core/error-handler.service';

@Component({
  selector: 'app-grupos-pesquisa',
  templateUrl: './grupos-pesquisa.component.html',
  styleUrls: ['./grupos-pesquisa.component.css']
})
export class GruposPesquisaComponent implements OnInit {

  filtro = new GrupoFiltro();
  grupos = [];

  constructor(
    private grupoService: GrupoService,
    private toasty: ToastyService,
    private confirmation: ConfirmationService,
    private errorHandler: ErrorHandlerService
  ) {
  }

  ngOnInit() {
  }

  pesquisar() {
    this.grupoService.pesquisar(this.filtro)
      .then(grupos => this.grupos = grupos)
      .catch(erro => this.errorHandler.handle(erro));
  }

  confirmarExclusao(grupo: any) {
    this.confirmation.confirm({
      message: 'Excluir grupo?',
      accept: () => {
        this.excluir(grupo);
      }
    });
  }

  excluir(grupo: any) {
    this.grupoService.excluir(grupo.id)
      .then(() => {
        this.pesquisar();
        this.toasty.success('Grupo removido!');
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

}
