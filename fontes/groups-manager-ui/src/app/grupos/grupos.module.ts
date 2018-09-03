import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {DataTableModule} from 'primeng/datatable';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {TooltipModule} from 'primeng/tooltip';
import {DropdownModule} from 'primeng/dropdown';
import {MessageModule} from 'primeng/message';
import {DataViewModule} from 'primeng/dataview';
import {PanelModule} from 'primeng/panel';
import {ScheduleModule} from 'primeng/schedule';

import {SharedModule} from '../shared/shared.module';

import {GruposCadastroComponent} from './grupos-cadastro/grupos-cadastro.component';
import {GruposPesquisaComponent} from './grupos-pesquisa/grupos-pesquisa.component';
import {GruposEventosComponent} from './grupos-eventos/grupos-eventos.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,

    ButtonModule,
    DataTableModule,
    InputTextModule,
    InputTextareaModule,
    TooltipModule,
    DropdownModule,
    MessageModule,
    DataViewModule,
    PanelModule,
    ScheduleModule,

    SharedModule
  ],
  declarations: [
    GruposCadastroComponent,
    GruposPesquisaComponent,
    GruposEventosComponent
  ],
  exports: []
})
export class GruposModule {
}
