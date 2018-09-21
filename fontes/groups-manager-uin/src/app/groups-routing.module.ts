import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {GruposCadastroComponent} from './grupos/grupos-cadastro/grupos-cadastro.component';

const routes: Routes = [
  {path: 'grupos', component: GruposCadastroComponent},
  {path: 'grupos/novo', component: GruposCadastroComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class GroupsRoutingModule {
}
