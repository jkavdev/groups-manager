import { Component, OnInit } from '@angular/core';

import { IntegranteService, IntegranteFiltro } from '../integrante.service';
import { ToastyService } from 'ng2-toasty';
import { ErrorHandlerService } from '../../core/error-handler.service';

@Component({
  selector: 'app-integrante-pesquisa',
  templateUrl: './integrante-pesquisa.component.html',
  styleUrls: ['./integrante-pesquisa.component.css']
})
export class IntegrantePesquisaComponent implements OnInit {

  filtro = new IntegranteFiltro();
  integrantes = [];

  constructor(
    private integranteService: IntegranteService,
    private errorHandler: ErrorHandlerService,
    private toasty: ToastyService

  ) {
  }

  ngOnInit() {
  }

  pesquisar() {
    this.integranteService.pesquisar(this.filtro)
      .then(integrantes => this.integrantes = integrantes);
  }

  efetivar(integrante: any) {
    if (integrante.cadastroEfetivado == false) {
      this.integranteService.efetivar(integrante.id)
        .then(() => {
          integrante.cadastroEfetivado = true;
          this.toasty.success(`Integrante efetivado`);
        })
        .catch(erro => this.errorHandler.handle(erro));
    }
  }

}
