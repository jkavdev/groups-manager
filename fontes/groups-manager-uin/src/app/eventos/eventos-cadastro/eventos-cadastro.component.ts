import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

import {MessageService, SelectItem} from 'primeng/api';

import {EventoService} from '../evento.service';
import {GrupoService} from '../../grupos/grupo.service';
import {Evento} from '../../core/model';
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
  ufs: SelectItem[];
  evento = new Evento();

  constructor(private fb: FormBuilder,
              private eventoService: EventoService,
              private grupoService: GrupoService) {
  }

  ngOnInit() {

    const endereco = this.fb.group({
      'uf': new FormControl('', Validators.required),
      'cep': new FormControl('', Validators.required),
      'logradouro': new FormControl('', Validators.required),
      'unidade': new FormControl('', Validators.required),
      'bairro': new FormControl('', Validators.required),
      'complemento': new FormControl('', Validators.required),
      'localidade': new FormControl('', Validators.required)
    });

    this.eventoForm = this.fb.group({
      'data': new FormControl('', Validators.required),
      'descricao': new FormControl('', Validators.required),
      'valor': new FormControl(''),
      'objetivo': new FormControl('', Validators.required),
      'lotacaoMaxima': new FormControl('', Validators.required),
      'grupoId': new FormControl('', Validators.required),
      'endereco': endereco
    });
    this.buscarGrupos();
    this.buscarUFs();
    console.log(this.grupos);
    console.log(this.ufs);
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
      .then(ufs1 => {
        this.ufs = [];
        this.ufs.push({label: 'Selecione o Estado', value: null});
        ufs1.forEach(uf => this.ufs.push({label: uf.descricao, value: uf.sigla}));
      })
      .catch(erro => console.log((erro)));
  }

  salvar(form: FormControl) {
    console.log(form);
    console.log(this.evento);
    this.eventoService.salvar(this.evento)
      .then(() => {
      });
  }

  limpar(form: FormControl) {
    // console.log(JSON.stringify(this.eventoForm));
    console.log(JSON.stringify(form.value));
    form.reset();

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
