import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {NoticiaPesquisaComponent} from './noticias/noticia-pesquisa/noticia-pesquisa.component';
import {NoticiaCadastroComponent} from './noticias/noticia-cadastro/noticia-cadastro.component';
import {GruposPesquisaComponent} from './grupos/grupos-pesquisa/grupos-pesquisa.component';
import {GruposCadastroComponent} from './grupos/grupos-cadastro/grupos-cadastro.component';
import {IntegrantePesquisaComponent} from './integrantes/integrante-pesquisa/integrante-pesquisa.component';
import {EventoCadastroComponent} from './eventos/evento-cadastro/evento-cadastro.component';
import {EventoPesquisaComponent} from './eventos/evento-pesquisa/evento-pesquisa.component';
import {IntegranteCadastroComponent} from './integrantes/integrante-cadastro/integrante-cadastro.component';
import {PaginaNaoEncontradaComponent} from './core/pagina-nao-encontrada.component';
import {GruposEventosComponent} from "./grupos/grupos-eventos/grupos-eventos.component";

const routes: Routes = [
  {path: '', redirectTo: 'eventos', pathMatch: 'full'},
  {path: 'grupos', component: GruposPesquisaComponent},
  {path: 'grupos/novo', component: GruposCadastroComponent},
  {path: 'grupos/:id/eventos', component: GruposEventosComponent},
  {path: 'grupos/:id/eventos/novo', component: EventoCadastroComponent},
  {path: 'integrantes', component: IntegrantePesquisaComponent},
  {path: 'integrantes/novo', component: IntegranteCadastroComponent},
  {path: 'eventos', component: EventoPesquisaComponent},
  {path: 'eventos/novo', component: EventoCadastroComponent},
  {path: 'noticias', component: NoticiaPesquisaComponent},
  {path: 'noticias/nova', component: NoticiaCadastroComponent},
  {path: 'pagina-nao-encontrada', component: PaginaNaoEncontradaComponent},
  {path: '**', redirectTo: 'pagina-nao-encontrada'},
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
export class GroupsRoutingModule {
}
