import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

import {MessageService} from 'primeng/api';
import {IntegranteService} from '../integrante.service';

@Component({
  selector: 'app-integrantes-cadastro',
  templateUrl: './integrantes-cadastro.component.html',
  styleUrls: ['./integrantes-cadastro.component.css'],
  providers: [MessageService]
})
export class IntegrantesCadastroComponent implements OnInit {

  integranteForm: FormGroup;

  constructor(private fb: FormBuilder,
              private messageServico: MessageService,
              private integranteService: IntegranteService) {
  }

  ngOnInit() {
    this.integranteForm = this.integranteGroupControl();
  }

  private integranteGroupControl() {
    return this.fb.group({
      'nome': new FormControl('', Validators.required),
      'idade': new FormControl('', Validators.required)
    });
  }

  salvar(integrante: any) {
    this.integranteService.salvar(integrante)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Integrante ${integrante.nome} adicionado!`});
        this.integranteForm.reset();
      })
      .catch(erro => this.messageServico.add({severity: 'error', summary: `Erro!`, detail: erro}));
  }

  limpar(form: FormControl) {
    form.reset();
  }

}
