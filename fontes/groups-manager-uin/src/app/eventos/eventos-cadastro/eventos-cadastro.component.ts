import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

import {MessageService, SelectItem} from 'primeng/api';

import {EventoService} from '../evento.service';
import {GrupoService} from '../../grupos/grupo.service';
import {Endereco, Evento} from '../../core/model';
import {GrupoFilter} from '../../core/filters';


@Component({
  selector: 'app-eventos-cadastro',
  templateUrl: './eventos-cadastro.component.html',
  styleUrls: ['./eventos-cadastro.component.css'],
  providers: [MessageService]
})
export class EventosCadastroComponent implements OnInit {

  eventoForm: FormGroup;
  grupos: SelectItem[];
  ufs = [];
  evento = new Evento();

  constructor(private fb: FormBuilder,
              private eventoService: EventoService,
              private grupoService: GrupoService) {
  }

  ngOnInit() {
    this.eventoForm = this.fb.group({
      'data': new FormControl('', Validators.compose([Validators.required, Validators.minLength(5)])),
      'descricao': new FormControl('', Validators.compose([Validators.required, Validators.minLength(5)])),
      'valor': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'objetivo': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'lotacaoMaxima': new FormControl('', Validators.required),
      'grupo.id': new FormControl('', Validators.required),
      'endereco.cep': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'endereco.logradouro': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'endereco.numero': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'endereco.bairro': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'endereco.cidade': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)])),
      'endereco.complemento': new FormControl('', Validators.compose([Validators.required, Validators.minLength(10)]))
    });
    this.buscarGrupos();
    this.buscarUFs();
  }

  buscarGrupos() {
    this.grupoService.pesquisar(new GrupoFilter())
      .then(grupos => {
        this.grupos = [];
        this.grupos.push({label: 'Selecione um Grupo', value: null});
        grupos.forEach(grupo => this.grupos.push({label: grupo.nome, value: grupo.id}));
      })
      .catch(erro => console.log(erro));
  }

  buscarUFs() {
    this.eventoService.ufs()
      .then(ufs => {
        this.ufs = [];
        this.ufs.push({label: 'Selecione o Estado', value: null});
        ufs.forEach(uf => this.ufs.push({label: '(' + uf.descricao + ')' + ' - ' + uf.sigla, value: uf}));
      })
      .catch(erro => console.log((erro)));
  }

  salvar(evento: any) {
    console.log(evento);
  }

  limpar() {
    console.log(JSON.parse(this.eventoForm.value));
    this.eventoForm.reset();

    /**
     * nao eh necessario
     * mas deve ser feitos mais testes
     * na versao que foi testado
     * o angular executa o reset depois do new Evento
     */
    // setTimeout(function(){
    //   this.evento = new Evento();
    // }.bind(this.evento), 1);

    this.evento = new Evento();
  }


}
