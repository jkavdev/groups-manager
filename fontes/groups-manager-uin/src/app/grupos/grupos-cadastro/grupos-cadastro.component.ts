import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

import {MessageService, SelectItem} from 'primeng/api';
import {GrupoService} from '../grupo.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

@Component({
  selector: 'app-grupos-cadastro',
  templateUrl: './grupos-cadastro.component.html',
  styleUrls: ['./grupos-cadastro.component.css'],
  providers: [MessageService]
})
export class GruposCadastroComponent implements OnInit {

  grupoForm: FormGroup;
  statusGrupo: SelectItem[];

  constructor(private fb: FormBuilder,
              private messageServico: MessageService,
              private errorhandler: ErrorHandlerService,
              private grupoService: GrupoService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.buscarStatusGrupos();
    this.grupoForm = this.fb.group({
      'id': [],
      'nome': new FormControl('', Validators.compose([Validators.required, Validators.minLength(5)])),
      'objetivo': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'statusGrupoId': new FormControl('', Validators.required)
    });

    const grupoId = !(this.route.snapshot.params['id'] === 'novo') && this.route.snapshot.params['id'] ;

    if (grupoId) {
      this.buscarGrupo(grupoId);
    }
  }

  buscarStatusGrupos() {
    this.grupoService.todosStatusGrupos()
      .then(statuses => {
        this.statusGrupo = [];
        this.statusGrupo.push({label: 'Selecione um Status Grupo', value: null});
        statuses.forEach(status => this.statusGrupo.push({label: status.nome, value: status.id}));
      }).catch(error => this.errorhandler.handle(error));
  }

  buscarGrupo(id: number) {
    this.grupoService.buscarPor(id)
      .then(grupo => {
        this.grupoForm.patchValue(grupo);
      })
      .catch(erro => this.errorhandler.handle(erro));
  }

  salvar() {
    if (this.editando) {
      this.alterarIntegrante();
    } else {
      this.adicionarIntegrante();
    }
  }

  private adicionarIntegrante() {
    const grupo = this.grupoForm.value;
    this.grupoService.salvar(grupo)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Grupo ${grupo.nome} salvo!`});
        this.grupoForm.reset();
      }).catch(erro => this.messageServico.add({severity: 'error', summary: erro, detail: `Erro ao adicionar Grupo ${grupo.nome}`}));
  }

  private alterarIntegrante() {
    const grupo = this.grupoForm.value;
    this.grupoService.atualizar(grupo)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Grupo ${grupo.nome} alterado!`});
        this.grupoForm.reset();
      }).catch(error => this.errorhandler.handle(error));
  }

  get editando() {
    return Boolean(this.grupoForm.get('id').value);
  }

  limpar() {
    this.grupoForm.reset();
  }

}
