import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Router} from '@angular/router';

import {ToastyService} from 'ng2-toasty';
import {SelectItem} from "primeng/api";

import {GrupoService} from '../grupo.service';
import {ErrorHandlerService} from '../../core/error-handler.service';
import {Grupo} from '../../core/model';

@Component({
  selector: 'app-grupos-cadastro',
  templateUrl: './grupos-cadastro.component.html',
  styleUrls: ['./grupos-cadastro.component.css']
})
export class GruposCadastroComponent implements OnInit {

  grupo = new Grupo();
  statusGrupo: SelectItem[];

  constructor(
    private grupoService: GrupoService,
    private toasty: ToastyService,
    private errorHandler: ErrorHandlerService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.status();
  }

  status() {
    this.grupoService.todosStatus()
      .then(status => {
        this.statusGrupo = [];
        this.statusGrupo.push({label: 'Selecione um Status Grupo', value: null});
        status.forEach(status => this.statusGrupo.push({label: status.nome, value: status}));
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  salvar(form: FormControl) {
    this.grupoService.salvar(this.grupo)
      .then(() => {
        this.toasty.success('Grupo adicionado!');

        form.reset();
        this.grupo = new Grupo();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  limpar(form: FormControl) {
    form.reset();

    this.grupo = new Grupo();
    this.router.navigate(['/grupos/novo'])
  }

}
