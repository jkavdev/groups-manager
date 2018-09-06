import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

import {Endereco, ViacepService} from '@brunoc/ngx-viacep';
import {ToastyService} from 'ng2-toasty';
import {SelectItem} from "primeng/api";

import {Evento} from '../../core/model';
import {EventoService} from '../evento.service';
import {GrupoFiltro, GrupoService} from "../../grupos/grupo.service";
import {ErrorHandlerService} from "../../core/error-handler.service";

@Component({
  selector: 'app-evento-cadastro',
  templateUrl: './evento-cadastro.component.html',
  styleUrls: ['./evento-cadastro.component.css']
})
export class EventoCadastroComponent implements OnInit {

  grupos: SelectItem[];
  ufs = [];
  endereco: Endereco;
  evento = new Evento();

  constructor(
    private viacepService: ViacepService,
    private eventoService: EventoService,
    private grupoService: GrupoService,
    private toasty: ToastyService,
    private router: Router,
    private route: ActivatedRoute,
    private errorHandler: ErrorHandlerService,
  ) {
  }

  ngOnInit() {
    this.buscarGrupos();
    this.buscarUFs();
    console.log(this.route.snapshot.params['id']);
  }

  buscarGrupos() {
    this.grupoService.pesquisar(new GrupoFiltro())
      .then(grupos => {
        this.grupos = [];
        this.grupos.push({label: 'Selecione um Grupo', value: null});
        grupos.forEach(grupo => this.grupos.push({label: grupo.nome, value: grupo.id}));
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  buscarUFs() {
    this.eventoService.ufs()
      .then(ufs => {
        this.ufs = [];
        this.ufs.push({label: 'Selecione o Estado', value: null});
        ufs.forEach(uf => this.ufs.push({label: '(' + uf.descricao + ')' + ' - ' + uf.sigla, value: uf}));
      })
      .catch(erro => this.errorHandler.handle(erro));
  }

  salvar(form: FormControl) {
    this.eventoService.salvar(this.evento)
      .then(() => {
        this.toasty.success('Evento salvo!')
      })
  }

  buscarEndereco(cep: string) {
    this.viacepService.buscarPorCep(cep)
      .then((endereco: Endereco) => {

        this.evento.endereco.bairro = endereco.bairro;
        this.evento.endereco.cep = endereco.cep;
        this.evento.endereco.complemento = endereco.complemento;
        this.evento.endereco.uf = endereco.uf;
        this.evento.endereco.logradouro = endereco.logradouro;
        this.evento.endereco.localidade = endereco.localidade;
        this.evento.endereco.unidade = endereco.unidade;

        this.toasty.success('Endereço encontrado no ViaCep');
      })
  }

  limpar(form: FormControl) {
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
    this.router.navigate(['/eventos/novo'])
  }

}
