import {Component, OnInit} from '@angular/core';
import {MessageService, SelectItem} from 'primeng/api';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {GrupoService} from '../grupo.service';

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
              private grupoService: GrupoService) {
  }

  ngOnInit() {
    this.buscarStatusGrupos();
    this.grupoForm = this.fb.group({
      'nome': new FormControl('', Validators.compose([Validators.required, Validators.minLength(5)])),
      'objetivo': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'statusGrupoId': new FormControl('', Validators.required)
    });

    this.messageServico.add({severity: 'info', summary: 'Success', detail: 'Submetido'});

  }

  buscarStatusGrupos() {
    this.grupoService.todosStatusGrupos()
      .then(statuses => {
        this.statusGrupo = [];
        this.statusGrupo.push({label: 'Selecione um Status Grupo', value: null});
        statuses.forEach(status => this.statusGrupo.push({label: status.nome, value: status.id}));
      })
      .catch(erro => this.messageServico.add({severity: 'error', summary: erro, detail: 'Erro ao buscar Status Grupos'}));
  }

  salvar(grupo: any) {
    this.grupoService.salvar(grupo)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Grupo ${grupo.nome} adicionado!`});

        this.grupoForm.reset();
      })
      .catch(erro => this.messageServico.add({severity: 'error', summary: erro, detail: `Erro ao adicionar Grupo ${grupo.nome}`}));
  }

  limpar() {
    this.grupoForm.reset();
  }

}
