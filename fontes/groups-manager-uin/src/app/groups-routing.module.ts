import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {GruposCadastroComponent} from './grupos/grupos-cadastro/grupos-cadastro.component';
import {GruposPesquisaComponent} from './grupos/grupos-pesquisa/grupos-pesquisa.component';
import {IntegrantesPesquisaComponent} from './integrantes/integrantes-pesquisa/integrantes-pesquisa.component';
import {IntegrantesCadastroComponent} from './integrantes/integrantes-cadastro/integrantes-cadastro.component';
import {EventosPesquisaComponent} from './eventos/eventos-pesquisa/eventos-pesquisa.component';
import {EventosCadastroComponent} from './eventos/eventos-cadastro/eventos-cadastro.component';

const routes: Routes = [
  {path: 'grupos', component: GruposPesquisaComponent},
  {path: 'grupos/novo', component: GruposCadastroComponent},
  {path: 'integrantes', component: IntegrantesPesquisaComponent},
  {path: 'integrantes/novo', component: IntegrantesCadastroComponent},
  {path: 'eventos', component: EventosPesquisaComponent},
  {path: 'eventos/novo', component: EventosCadastroComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class GroupsRoutingModule {
}
