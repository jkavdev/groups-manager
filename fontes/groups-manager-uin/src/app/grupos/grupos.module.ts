import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

import {InputTextModule} from 'primeng/components/inputtext/inputtext';
import {ButtonModule} from 'primeng/components/button/button';
import {DataViewModule} from 'primeng/components/dataview/dataview';
import {PanelModule} from 'primeng/components/panel/panel';
import {TooltipModule} from 'primeng/components/tooltip/tooltip';
import {DropdownModule} from 'primeng/components/dropdown/dropdown';
import {InputTextareaModule} from 'primeng/components/inputtextarea/inputtextarea';
import {MessageModule} from 'primeng/components/message/message';
import {ToastModule} from 'primeng/components/toast/toast';
import {ScheduleModule} from 'primeng/components/schedule/schedule';
import {CardModule} from 'primeng/components/card/card';
import {PickListModule} from 'primeng/components/picklist/picklist';
import {TableModule} from 'primeng/components/table/table';

import {GruposCadastroComponent} from './grupos-cadastro/grupos-cadastro.component';
import {GruposPesquisaComponent} from './grupos-pesquisa/grupos-pesquisa.component';
import {GruposEventosComponent} from './grupos-eventos/grupos-eventos.component';
import {GruposIntegrantesComponent} from './grupos-integrantes/grupos-integrantes.component';
import {GruposVincularIntegrantesComponent} from './grupos-vincular-integrantes/grupos-vincular-integrantes.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule,

    InputTextModule,
    ButtonModule,
    DataViewModule,
    PanelModule,
    TooltipModule,
    DropdownModule,
    InputTextareaModule,
    MessageModule,
    ToastModule,
    ScheduleModule,
    CardModule,
    PickListModule,
    TableModule
  ],
  declarations: [
    GruposCadastroComponent,
    GruposPesquisaComponent,
    GruposEventosComponent,
    GruposIntegrantesComponent,
    GruposIntegrantesComponent,
    GruposVincularIntegrantesComponent
  ],
  exports: []
})
export class GruposModule {
}
