import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {CalendarModule} from 'primeng/components/calendar/calendar';
import {ButtonModule} from 'primeng/components/button/button';
import {EventosPesquisaComponent} from './eventos-pesquisa/eventos-pesquisa.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,

    CalendarModule,
    ButtonModule,
  ],
  declarations: [
    EventosPesquisaComponent
  ],
  exports: [
    EventosPesquisaComponent
  ]
})
export class EventosModule {
}
