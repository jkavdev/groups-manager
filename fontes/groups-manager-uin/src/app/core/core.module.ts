import {LOCALE_ID, NgModule} from '@angular/core';
import {CommonModule, registerLocaleData} from '@angular/common';
import localePt from '@angular/common/locales/pt-PT';

import {ButtonModule} from 'primeng/components/button/button';
import {MegaMenuModule} from 'primeng/components/megamenu/megamenu';
import {TieredMenuModule} from 'primeng/components/tieredmenu/tieredmenu';

import {ConfirmationService, ConfirmDialogModule, MessageService} from 'primeng/primeng';

import {ErrorHandlerService} from './error-handler.service';
import {CepService} from './cep.service';

import {NavbarComponent} from './navbar/navbar.component';
import {PaginaNaoEncontradaComponent} from './pagina-nao-encontrada.component';

registerLocaleData(localePt, 'pt-BR');

@NgModule({
  imports: [
    CommonModule,

    ButtonModule,
    MegaMenuModule,
    TieredMenuModule,
    ConfirmDialogModule
  ],
  declarations: [
    NavbarComponent,
    PaginaNaoEncontradaComponent
  ],
  exports: [
    NavbarComponent,
    ConfirmDialogModule
  ],
  providers: [
    ErrorHandlerService,
    ConfirmationService,
    MessageService,
    CepService,
    {provide: LOCALE_ID, useValue: 'pt-BR'}
  ]
})
export class CoreModule {
}
