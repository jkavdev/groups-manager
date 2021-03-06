import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

import {MessageService} from 'primeng/api';
import {TopicoService} from '../../topicos/topico.service';
import {ErrorHandlerService} from '../../core/error-handler.service';
import {NoticiaService} from '../noticia.service';
import {GrupoService} from '../../grupos/grupo.service';

import {GrupoFilter} from '../../core/filters';

@Component({
  selector: 'app-noticias-cadastro',
  templateUrl: './noticias-cadastro.component.html',
  styleUrls: ['./noticias-cadastro.component.css'],
  providers: [MessageService, ErrorHandlerService],
  encapsulation: ViewEncapsulation.None
})
export class NoticiasCadastroComponent implements OnInit {

  noticiaForm: FormGroup;
  topicos = [];
  grupos = [];
  verNoticia = false;

  constructor(
    private fb: FormBuilder,
    private topicoService: TopicoService,
    private grupoService: GrupoService,
    private noticiaService: NoticiaService,
    private errorHandler: ErrorHandlerService,
    private msgService: MessageService
  ) {
  }

  ngOnInit() {
    this.noticiaForm = this.noticiaGroupControl();
    this.buscarTopicos();
    this.buscarGrupos();
  }

  noticiaGroupControl() {
    return this.fb.group({
      'id': new FormControl(''),
      'titulo': new FormControl('', Validators.required),
      'publica': new FormControl('', Validators.required),
      'topicos': new FormControl('', Validators.required),
      'grupo': this.grupoGroupControl(),
      'corpo': new FormControl('', Validators.required),
    });
  }

  grupoGroupControl() {
    return this.fb.group({
      'id': new FormControl('', Validators.required),
    });
  }

  salvar() {
    if (this.editando) {
      this.alterarNoticia();
    } else {
      this.adicionarNoticia();
    }
  }

  get editando() {
    return Boolean(this.noticiaForm.get('id').value);
  }

  private adicionarNoticia() {
    const noticia = this.noticiaForm.value;
    this.noticiaService.adicionar(noticia)
      .then(noticiaSalva => {
        this.noticiaForm.patchValue(noticiaSalva);
        this.msgService.add({severity: 'info', summary: `Sucesso!`, detail: `Notícia adicionada!`});
      }).catch(error => this.errorHandler.handle(error));
  }

  private alterarNoticia() {
    const noticia = this.noticiaForm.value;
    this.noticiaService.atualizar(noticia)
      .then(() => {
        this.msgService.add({severity: 'info', summary: `Sucesso!`, detail: `Notícia alterada!`});
      }).catch(error => this.errorHandler.handle(error));
  }

  buscarTopicos() {
    this.topicoService.pesquisar()
      .then(topicos => {
        this.topicos = topicos.map(t => ({label: t.descricao, value: t.topico}));
      }).catch(erro => this.errorHandler.handle(erro));
  }

  buscarGrupos() {
    this.grupoService.pesquisar(new GrupoFilter())
      .then(grupos => {
        this.grupos = [];
        this.grupos.push({label: 'Selecione um Grupo', value: null});
        grupos.forEach(grupo => this.grupos.push({label: grupo.nome, value: grupo.id}));
      }).catch(erro => this.errorHandler.handle(erro));
  }

  limpar() {
    this.noticiaForm.reset();
    this.verNoticia = false;
  }

}
