import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {CurrencyMaskModule} from 'ng2-currency-mask';

import {InputMaskModule} from 'primeng/inputmask';
import {CalendarModule} from 'primeng/calendar';
import {SpinnerModule} from 'primeng/spinner';
import {DropdownModule} from 'primeng/dropdown';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {ScheduleModule} from 'primeng/schedule';
import {PanelModule} from 'primeng/panel';
import {CardModule} from 'primeng/card';
import {TableModule} from 'primeng/table';
import {CarouselModule} from 'primeng/carousel';

import {SharedModule} from '../shared/shared.module';

import {EventoCadastroComponent} from './evento-cadastro/evento-cadastro.component';
import {EventoPesquisaComponent} from './evento-pesquisa/evento-pesquisa.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    BrowserAnimationsModule,

    CurrencyMaskModule,

    CalendarModule,
    ButtonModule,
    InputTextModule,
    InputTextareaModule,
    SpinnerModule,
    DropdownModule,
    InputMaskModule,
    ScheduleModule,
    PanelModule,
    CardModule,
    TableModule,
    CarouselModule,

    SharedModule
  ],
  declarations: [
    EventoCadastroComponent,
    EventoPesquisaComponent
  ],
  exports: []
})
export class EventosModule {
}
