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
          {label: 'Grupos', icon: 'pi pi-fw pi-search', routerLink: '/grupos'},
          {label: 'Grupo', icon: 'pi pi-fw pi-plus', routerLink: '/grupos/novo'}
        ]
      },
      {
        label: 'Integrantes',
        icon: 'pi pi-fw pi-user-minus',
        items: [
          {label: 'Integrantes', icon: 'pi pi-fw pi-search', routerLink: '/integrantes'},
          {label: 'Integrante', icon: 'pi pi-fw pi-plus', routerLink: '/integrantes/novo'}
        ]
      },
      {
        label: 'Eventos',
        icon: 'pi pi-fw pi-calendar',
        items: [
          {label: 'Eventos', icon: 'pi pi-fw pi-search', routerLink: '/eventos'},
          {label: 'Evento', icon: 'pi pi-fw pi-plus', routerLink: '/eventos/novo'}
        ]
      },
      {
        label: 'Notícias',
        icon: 'pi pi-fw pi-bookmark',
        items: [
          {label: 'Notícias', icon: 'pi pi-fw pi-search', routerLink: '/noticias'},
          {label: 'Notícia', icon: 'pi pi-fw pi-plus', routerLink: '/noticias/novo'}
        ]
      },
    ];
  }

}
