import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

import {DataTableModule} from 'primeng/datatable';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {TooltipModule} from 'primeng/tooltip';
import {InputMaskModule} from 'primeng/inputmask';
import {SelectButtonModule} from 'primeng/selectbutton';
import {SpinnerModule} from 'primeng/spinner';
import {FieldsetModule} from 'primeng/fieldset';
import {MessageModule} from 'primeng/components/message/message';
import {ToastModule} from 'primeng/components/toast/toast';
import {PanelModule} from 'primeng/components/panel/panel';
import {DataViewModule} from 'primeng/components/dataview/dataview';
import {DialogModule} from 'primeng/components/dialog/dialog';
import {ScrollPanelModule} from 'primeng/primeng';

import {IntegrantesCadastroComponent} from './integrantes-cadastro/integrantes-cadastro.component';
import {IntegrantesPesquisaComponent} from './integrantes-pesquisa/integrantes-pesquisa.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule,

    ButtonModule,
    DataTableModule,
    InputTextModule,
    TooltipModule,
    InputMaskModule,
    SelectButtonModule,
    SpinnerModule,
    FieldsetModule,
    MessageModule,
    ToastModule,
    PanelModule,
    DataViewModule,
    DialogModule,
    ScrollPanelModule
  ],
  declarations: [
    IntegrantesCadastroComponent,
    IntegrantesPesquisaComponent
  ],
  exports: []
})
export class IntegrantesModule {
}
