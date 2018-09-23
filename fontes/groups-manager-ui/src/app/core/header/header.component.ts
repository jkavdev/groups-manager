import {Component, Inject, OnInit} from '@angular/core';
import {DOCUMENT} from "@angular/platform-browser";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  menuVisible = "";

  constructor(@Inject(DOCUMENT) private document) {
  }

  ngOnInit() {
  }

  menu() {
    console.log('passei aqui')
    var body = this.document.getElementsByClassName('single');
    if (this.menuVisible.length < 0)
      body.className = this.exibirMenu();
    else
      body.className = this.fecharMenu();
  }

  exibirMenu() {
    this.menuVisible = 'is-menu-visible';
  }

  fecharMenu() {
    this.menuVisible = '';
  }

}
