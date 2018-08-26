import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { DataTableModule } from 'primeng/datatable';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TooltipModule } from 'primeng/tooltip';
import { InputMaskModule } from 'primeng/inputmask';
import { SelectButtonModule } from 'primeng/selectbutton';

import { SharedModule } from '../shared/shared.module';

import { IntegrantePesquisaComponent } from './integrante-pesquisa/integrante-pesquisa.component';
import { IntegranteCadastroComponent } from './integrante-cadastro/integrante-cadastro.component';
import { CalendarModule } from 'primeng/calendar';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,

    ButtonModule,
    DataTableModule,
    InputTextModule,
    TooltipModule,
    InputMaskModule,
    SelectButtonModule,
    CalendarModule,

    SharedModule
  ],
  declarations: [
    IntegrantePesquisaComponent,
    IntegranteCadastroComponent
  ],
  exports: []
})
export class IntegrantesModule { }
