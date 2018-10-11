import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

import {MessageService, SelectItem} from 'primeng/api';
import {EventoService} from '../evento.service';
import {GrupoService} from '../../grupos/grupo.service';
import {CepService} from '../../core/cep.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

import {GrupoFilter} from '../../core/filters';

@Component({
  selector: 'app-eventos-cadastro',
  templateUrl: './eventos-cadastro.component.html',
  styleUrls: ['./eventos-cadastro.component.css'],
  providers: [MessageService, ErrorHandlerService]
})
export class EventosCadastroComponent implements OnInit {

  eventoForm: FormGroup;
  grupos: SelectItem[];
  ufs: SelectItem[];

  constructor(private fb: FormBuilder,
              private eventoService: EventoService,
              private grupoService: GrupoService,
              private cepService: CepService,
              private route: ActivatedRoute,
              private messageServico: MessageService,
              private errorhandler: ErrorHandlerService) {
  }

  ngOnInit() {
    this.eventoForm = this.eventoGroupControl();
    this.buscarGrupos();
    this.buscarUFs();

    const eventoId = this.route.snapshot.params['id'];

    if (eventoId) {
      this.buscarEvento(eventoId);
    }
  }

  private eventoGroupControl() {
    return this.fb.group({
      'id': [],
      'data': new FormControl('', Validators.required),
      'descricao': new FormControl('', Validators.required),
      'valor': new FormControl('1'),
      'objetivo': new FormControl('', Validators.required),
      'lotacaoMaxima': new FormControl('', Validators.required),
      'grupoId': new FormControl('', Validators.required),
      'endereco': this.enderecoGroupControl()
    });
  }

  private enderecoGroupControl() {
    return this.fb.group({
      'id': [],
      'uf': new FormControl('', Validators.required),
      'cep': new FormControl('', Validators.required),
      'logradouro': new FormControl('', Validators.required),
      'unidade': new FormControl('', Validators.required),
      'bairro': new FormControl('', Validators.required),
      'complemento': new FormControl('', Validators.required),
      'localidade': new FormControl('', Validators.required)
    });
  }

  buscarGrupos() {
    this.grupoService.pesquisar(new GrupoFilter())
      .then(grupos => {
        this.grupos = [];
        this.grupos.push({label: 'Selecione um Grupo', value: null});
        grupos.forEach(grupo => this.grupos.push({label: grupo.nome, value: grupo.id}));
      }).catch(error => this.errorhandler.handle(error));
  }

  buscarUFs() {
    this.eventoService.ufs()
      .then(ufs1 => {
        this.ufs = [];
        this.ufs.push({label: 'Selecione o Estado', value: null});
        ufs1.forEach(uf => this.ufs.push({label: uf.descricao, value: uf.sigla}));
      }).catch(error => this.errorhandler.handle(error));
  }

  buscarCEP(cep: string) {
    this.cepService.buscar(cep)
      .then(endereco => {
        this.eventoForm.controls['endereco'].patchValue(endereco);
      });
  }

  salvar() {
    if (this.editando) {
      this.alterarEvento();
    } else {
      this.adicionarEvento();
    }
  }

  private adicionarEvento() {
    const evento = this.eventoForm.value;
    this.eventoService.salvar(evento)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Evento ${evento.descricao} adicionado!`});
        this.eventoForm.reset();
      }).catch(error => this.errorhandler.handle(error));
  }

  private alterarEvento() {
    const evento = this.eventoForm.value;
    this.eventoService.atualizar(evento)
      .then(() => {
        this.messageServico.add({severity: 'info', summary: `Sucesso!`, detail: `Evento ${evento.descricao} alterado!`});
        this.eventoForm.reset();
      }).catch(error => this.errorhandler.handle(error));
  }

  limpar() {
    this.eventoForm.reset();
  }

  private buscarEvento(eventoId: number) {
    this.eventoService.buscarPor(eventoId)
      .then(evento => {
        this.eventoForm.patchValue(evento);
      })
      .catch(error => this.errorhandler.handle(error));
  }

  get editando() {
    return Boolean(this.eventoForm.get('id').value);
  }
}
