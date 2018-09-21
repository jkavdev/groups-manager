import {Component, OnInit} from '@angular/core';

import {GrupoService} from '../grupo.service';
import {GrupoFilter} from '../../core/filters';
import {ConfirmationService, MessageService} from 'primeng/api';

@Component({
  selector: 'app-grupos-pesquisa',
  templateUrl: './grupos-pesquisa.component.html',
  styleUrls: ['./grupos-pesquisa.component.css'],
  providers: [MessageService]
})
export class GruposPesquisaComponent implements OnInit {

  grupos = [];
  filtro = new GrupoFilter();

  constructor(private grupoService: GrupoService,
              private messageService: MessageService,
              private confirmation: ConfirmationService) {
  }

  ngOnInit() {
    this.pesquisarGrupos();
  }

  pesquisarGrupos() {
    this.grupoService.pesquisar(this.filtro)
      .then(resp => this.grupos = resp)
      .catch(error => console.log(error));
  }

  excluir(grupo: any) {
    this.confirmation.confirm({
      message: `Deseja remover o Grupo ${grupo.nome}?`,
      accept: () => {
        const index: number = this.grupos.indexOf(grupo, 0);
        if (index !== -1) {
          this.grupos.splice(index, 1);
          this.messageService.add({severity: 'info', summary: `Sucesso!`, detail: `Grupo ${grupo.nome} removido!`});
        }
      }
    });
  }

}
