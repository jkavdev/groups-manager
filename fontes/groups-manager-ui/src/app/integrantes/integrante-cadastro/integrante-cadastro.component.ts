import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl} from '@angular/forms';

import {SelectItem} from 'primeng/api';
import {ToastyService} from 'ng2-toasty';

import {IntegranteService} from '../integrante.service';
import {Grupo, Integrante} from '../../core/model';
import {ErrorHandlerService} from '../../core/error-handler.service';

@Component({
  selector: 'app-integrante-cadastro',
  templateUrl: './integrante-cadastro.component.html',
  styleUrls: ['./integrante-cadastro.component.css']
})
export class IntegranteCadastroComponent implements OnInit {

  integrante = new Integrante();
  sexos: SelectItem[];

  constructor(
    private integranteService: IntegranteService,
    private toasty: ToastyService,
    private errorHandler: ErrorHandlerService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.sexos = [];
    this.sexos.push({title: 'Masculino', value: 'MASCULINO', icon: 'fa fa-mars', label: 'Masculino'});
    this.sexos.push({title: 'Feminino', value: 'FEMININO', icon: 'fa fa-venus', label: 'Feminino'});
  }

  salvar(form: FormControl) {
    this.integranteService.salvar(this.integrante)
      .then(() => {
        this.toasty.success('Integrante adicionado!');

        form.reset();
        this.integrante = new Integrante();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  validar(cpf: string) {
    this.integranteService.validar(cpf)
      .then(() => {
        this.toasty.success(`${cpf} válido`)
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  limpar(form: FormControl) {
    form.reset();

    this.integrante = new Integrante();
    this.router.navigate(['/integrantes/novo'])
  }

}
