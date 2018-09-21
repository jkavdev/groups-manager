import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

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

import {IntegrantesCadastroComponent} from './integrantes-cadastro/integrantes-cadastro.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,

    ButtonModule,
    DataTableModule,
    InputTextModule,
    TooltipModule,
    InputMaskModule,
    SelectButtonModule,
    SpinnerModule,
    FieldsetModule,
    MessageModule,
    ToastModule
  ],
  declarations: [
    IntegrantesCadastroComponent
  ],
  exports: [
    IntegrantesCadastroComponent
  ]
})
export class IntegrantesModule {
}
