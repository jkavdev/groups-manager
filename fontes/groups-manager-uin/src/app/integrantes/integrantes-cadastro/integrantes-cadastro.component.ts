import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

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
              private integranteService: IntegranteService,
              private route: ActivatedRoute,
              private messageServico: MessageService,
              private errorhandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.integranteForm = this.integranteGroupControl();

    const integranteId = this.route.snapshot.params['id'];

    if (integranteId) {
      this.buscarIntegrante(integranteId);
    }
  }

  private integranteGroupControl() {
    return this.fb.group({
      'id': [],
      'nome': new FormControl('', Validators.required),
      'celular': new FormControl('', Validators.required),
      'idade': new FormControl('7', Validators.compose([Validators.required, Validators.min(7)]))
    });
  }

  salvar() {
    if (this.editando) {
      this.alterarIntegrante();
    } else {
      this.adicionarIntegrante();
    }
  }

  private adicionarIntegrante() {
    const integrante = this.integranteForm.value;
    this.integranteService.salvar(integrante)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Integrante ${integrante.nome} adicionado!`});
        this.integranteForm.reset();
      }).catch(error => this.errorhandler.handle(error));
  }

  private alterarIntegrante() {
    const integrante = this.integranteForm.value;
    this.integranteService.atualizar(integrante)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Integrante ${integrante.nome} alterado!`});
        this.integranteForm.reset();
      }).catch(error => this.errorhandler.handle(error));
  }

  limpar() {
    this.integranteForm.reset();
  }

  private buscarIntegrante(id: number) {
    this.integranteService.buscarPor(id)
      .then(integrante => this.integranteForm.patchValue(integrante))
      .catch(error => this.errorhandler.handle(error));
  }

  get editando() {
    return Boolean(this.integranteForm.get('id').value);
  }
}
