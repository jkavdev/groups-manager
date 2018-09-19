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
  pt: any;

  constructor(private eventoService: EventoService) {
  }

  ngOnInit() {
    this.pt = {
      firstDayOfWeek: 0,
      dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
      dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
      dayNamesMin: ['Do', 'Se', 'Te', 'Qu', 'Qu', 'Se', 'Sa'],
      monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
      monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
      today: 'Hoje',
      clear: 'Limpar'
    };
    this.pesquisarEventos();
  }

  pesquisarEventos() {
    this.eventoService.pesquisar(this.filtro)
      .then(eventos => this.eventos = eventos)
      .catch(erro => console.log(erro));
  }

}
