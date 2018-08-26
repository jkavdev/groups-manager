import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { GruposModule } from './grupos/grupos.module';
import { EventosModule } from './eventos/eventos.module';
import { IntegrantesModule } from './integrantes/integrantes.module';
import { NoticiasModule } from './noticias/noticias.module';
import { NoticiaPesquisaComponent } from './noticias/noticia-pesquisa/noticia-pesquisa.component';
import { NoticiaCadastroComponent } from './noticias/noticia-cadastro/noticia-cadastro.component';
import { GruposPesquisaComponent } from './grupos/grupos-pesquisa/grupos-pesquisa.component';
import { GruposCadastroComponent } from './grupos/grupos-cadastro/grupos-cadastro.component';
import { IntegrantePesquisaComponent } from './integrantes/integrante-pesquisa/integrante-pesquisa.component';
import { EventoCadastroComponent } from './eventos/evento-cadastro/evento-cadastro.component';
import { EventoPesquisaComponent } from './eventos/evento-pesquisa/evento-pesquisa.component';
import { IntegranteCadastroComponent } from './integrantes/integrante-cadastro/integrante-cadastro.component';
import { PaginaNaoEncontradaComponent } from './core/pagina-nao-encontrada.component';

const routes: Routes = [
  { path: '', redirectTo:'eventos', pathMatch: 'full' },
  { path: 'grupos', component: GruposPesquisaComponent },
  { path: 'grupos/novo', component: GruposCadastroComponent },
  { path: 'integrantes', component: IntegrantePesquisaComponent },
  { path: 'integrantes/novo', component: IntegranteCadastroComponent },
  { path: 'eventos', component: EventoPesquisaComponent },
  { path: 'eventos/novo', component: EventoCadastroComponent },
  { path: 'noticias', component: NoticiaPesquisaComponent },
  { path: 'noticias/nova', component: NoticiaCadastroComponent },
  { path: 'pagina-nao-encontrada', component: PaginaNaoEncontradaComponent },
  { path: '**', redirectTo: 'pagina-nao-encontrada' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  providers: [],
  exports: [
    RouterModule
  ]
})
export class GroupsRoutingModule { }
