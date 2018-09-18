import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  items: MenuItem[];

  constructor() {
  }

  ngOnInit() {
    this.items = [
      {
        label: 'Grupos',
        icon: 'pi pi-fw pi-home',
        items: [
          {label: 'Grupos', icon: 'pi pi-fw pi-search'},
          {label: 'Grupo', icon: 'pi pi-fw pi-plus'}
        ]
      },
      {
        label: 'Integrantes',
        icon: 'pi pi-fw pi-user-minus',
        items: [
          {label: 'Integrantes', icon: 'pi pi-fw pi-search'},
          {label: 'Integrante', icon: 'pi pi-fw pi-plus'}
        ]
      },
      {
        label: 'Eventos',
        icon: 'pi pi-fw pi-calendar',
        items: [
          {label: 'Eventos', icon: 'pi pi-fw pi-search'},
          {label: 'Evento', icon: 'pi pi-fw pi-plus'}
        ]
      },
      {
        label: 'Notícias',
        icon: 'pi pi-fw pi-bookmark',
        items: [
          {label: 'Notícias', icon: 'pi pi-fw pi-search'},
          {label: 'Notícia', icon: 'pi pi-fw pi-plus'}
        ]
      },
    ];
  }

}
