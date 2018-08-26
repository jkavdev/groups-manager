import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

import { SelectItem } from 'primeng/api';
import { ToastyService } from 'ng2-toasty';

import { TopicoService } from '../../topicos/topico.service';
import { ErrorHandlerService } from '../../core/error-handler.service';
import { Noticia } from '../../core/model';
import { NoticiaService } from '../noticia.service';

@Component({
  selector: 'app-noticia-cadastro',
  templateUrl: './noticia-cadastro.component.html',
  styleUrls: ['./noticia-cadastro.component.css']
})
export class NoticiaCadastroComponent implements OnInit {

  topicos = [];
  topicosSelecionados = [];
  grupos = [];
  corpoNoticia: string = '<div>Hello World!</div><div>PrimeNG <b>Editor</b> Rocks</div><div><br></div>';
  noticia = new Noticia();

  constructor(
    private topicoService: TopicoService,
    private errorHandler: ErrorHandlerService,
    private toasty: ToastyService,
    private noticiaService: NoticiaService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.buscarTopicos();
    this.grupos = [
      { label: 'GAM', value: { id: 2, nome: 'GAM' } },
      { label: 'Movimento', value: { id: 3, nome: 'Movimento' } }
    ];
  }

  salvar(form: FormControl) {
    console.log(this.noticia);
    this.noticiaService.adicionar(this.noticia)
      .then(() => {
        this.toasty.success('Noticia salva');
        this.noticia = new Noticia();
        form.reset();
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  buscarTopicos() {
    return this.topicoService.pesquisar()
      .then(topicos => {
        this.topicos = topicos.map(t => ({ label: t.descricao, value: t.topico }));
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  limpar(form: FormControl) {
    form.reset();

    this.noticia = new Noticia();
    this.router.navigate(['/noticias/nova'])
  }

}
