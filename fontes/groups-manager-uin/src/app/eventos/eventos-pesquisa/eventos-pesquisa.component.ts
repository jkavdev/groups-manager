import {Component, OnInit} from '@angular/core';
import {EventoService} from '../evento.service';
import {EventoFilter} from '../../core/filters';

@Component({
  selector: 'app-eventos-pesquisa',
  templateUrl: './eventos-pesquisa.component.html',
  styleUrls: ['./eventos-pesquisa.component.css']
})
export class EventosPesquisaComponent implements OnInit {

  filtro = new EventoFilter();
  eventos = [];

  constructor(private eventoService: EventoService) {
  }

  ngOnInit() {
    this.pesquisarEventos();
  }

  pesquisarEventos() {
    this.eventoService.pesquisar(this.filtro)
      .then(eventos => this.eventos = eventos)
      .catch(erro => console.log(erro));
  }

}
