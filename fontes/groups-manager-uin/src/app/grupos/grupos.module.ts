import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {InputTextModule} from 'primeng/components/inputtext/inputtext';
import {ButtonModule} from 'primeng/components/button/button';
import {DataViewModule} from 'primeng/components/dataview/dataview';
import {PanelModule} from 'primeng/components/panel/panel';
import {TooltipModule} from 'primeng/components/tooltip/tooltip';
import {DropdownModule} from 'primeng/components/dropdown/dropdown';
import {InputTextareaModule} from 'primeng/components/inputtextarea/inputtextarea';
import {MessageModule} from 'primeng/components/message/message';
import {ToastModule} from 'primeng/components/toast/toast';

import {GruposCadastroComponent} from './grupos-cadastro/grupos-cadastro.component';
import {GruposPesquisaComponent} from './grupos-pesquisa/grupos-pesquisa.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,

    InputTextModule,
    ButtonModule,
    DataViewModule,
    PanelModule,
    TooltipModule,
    DropdownModule,
    InputTextareaModule,
    MessageModule,
    ToastModule
  ],
  declarations: [
    GruposCadastroComponent,
    GruposPesquisaComponent
  ],
  exports: [
    GruposCadastroComponent,
    GruposPesquisaComponent
  ]
})
export class GruposModule {
}
