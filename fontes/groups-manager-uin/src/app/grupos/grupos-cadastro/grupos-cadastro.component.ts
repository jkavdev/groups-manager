import {Component, OnInit} from '@angular/core';
import {MessageService, SelectItem} from 'primeng/api';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

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
              private messageServico: MessageService) {
  }

  ngOnInit() {
    this.grupoForm = this.fb.group({
      'nome': new FormControl('', Validators.compose([Validators.required, Validators.minLength(5)])),
      'objetivo': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'status': new FormControl('', Validators.required)
    });

    this.statusGrupo = [];
    this.statusGrupo.push({label: 'Selecione Status do Grupo', value: null});
    this.statusGrupo.push({label: 'Movimento', value: 'MOVIMENTO'});
    this.statusGrupo.push({label: 'Pastoral', value: 'PASTORAL'});
  }

  onSubmit(value: string) {
    this.messageServico.add({severity: 'info', summary: 'Success', detail: 'Submetido'});
  }


}
