import {LOCALE_ID, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ButtonModule} from 'primeng/components/button/button';
import {MegaMenuModule} from 'primeng/components/megamenu/megamenu';
import {TieredMenuModule} from 'primeng/components/tieredmenu/tieredmenu';
import {ConfirmationService, ConfirmDialogModule, MessageService} from 'primeng/primeng';

import {ErrorHandlerService} from './error-handler.service';

import {NavbarComponent} from './navbar/navbar.component';

@NgModule({
  imports: [
    CommonModule,

    ButtonModule,
    MegaMenuModule,
    TieredMenuModule,
    ConfirmDialogModule
  ],
  declarations: [NavbarComponent],
  exports: [
    NavbarComponent,
    ConfirmDialogModule
  ],
  providers: [
    ErrorHandlerService,
    ConfirmationService,
    MessageService,
    {provide: LOCALE_ID, useValue: 'pt-BR'}
  ]
})
export class CoreModule {
}
