import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

import {CalendarModule} from 'primeng/components/calendar/calendar';
import {ButtonModule} from 'primeng/components/button/button';
import {SpinnerModule} from 'primeng/components/spinner/spinner';
import {DropdownModule} from 'primeng/components/dropdown/dropdown';
import {InputMaskModule} from 'primeng/components/inputmask/inputmask';
import {InputTextModule} from 'primeng/components/inputtext/inputtext';
import {TooltipModule} from 'primeng/components/tooltip/tooltip';
import {InputTextareaModule} from 'primeng/components/inputtextarea/inputtextarea';
import {MessageModule} from 'primeng/components/message/message';
import {ToastModule} from 'primeng/components/toast/toast';

import {EventosPesquisaComponent} from './eventos-pesquisa/eventos-pesquisa.component';
import {EventosCadastroComponent} from './eventos-cadastro/eventos-cadastro.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule,

    CalendarModule,
    ButtonModule,
    SpinnerModule,
    DropdownModule,
    InputMaskModule,
    InputTextModule,
    InputTextareaModule,
    TooltipModule,
    MessageModule,
    ToastModule
  ],
  declarations: [
    EventosPesquisaComponent,
    EventosCadastroComponent
  ],
  exports: []
})
export class EventosModule {
}
