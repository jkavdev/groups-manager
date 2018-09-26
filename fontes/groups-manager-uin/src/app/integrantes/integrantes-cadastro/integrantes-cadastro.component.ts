import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

import {MessageService} from 'primeng/api';
import {IntegranteService} from '../integrante.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

@Component({
  selector: 'app-integrantes-cadastro',
  templateUrl: './integrantes-cadastro.component.html',
  styleUrls: ['./integrantes-cadastro.component.css'],
  providers: [MessageService, ErrorHandlerService]
})
export class IntegrantesCadastroComponent implements OnInit {

  integranteForm: FormGroup;

  constructor(private fb: FormBuilder,
              private messageServico: MessageService,
              private integranteService: IntegranteService,
              private errorhandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.integranteForm = this.integranteGroupControl();
  }

  private integranteGroupControl() {
    return this.fb.group({
      'nome': new FormControl('', Validators.required),
      'idade': new FormControl('7', Validators.compose([Validators.required, Validators.minLength(7)]))
    });
  }

  salvar(integrante: any) {
    this.integranteService.salvar(integrante)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Integrante ${integrante.nome} adicionado!`});
        this.integranteForm.reset();
      })
      .catch(error => this.errorhandler.handle(error));
  }

  limpar() {
    this.integranteForm.reset();
  }

}
