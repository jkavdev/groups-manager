import {BrowserModule} from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpModule} from '@angular/http';

import {ConfirmationService} from 'primeng/api';

import {ConfirmDialogModule} from 'primeng/components/confirmdialog/confirmdialog';

import {CoreModule} from './core/core.module';
import {GruposModule} from './grupos/grupos.module';
import {EventosModule} from './eventos/eventos.module';
import {IntegrantesModule} from './integrantes/integrantes.module';

import {AppComponent} from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule,

    CoreModule,
    GruposModule,
    EventosModule,
    IntegrantesModule,
    ConfirmDialogModule
  ],
  providers: [
    ConfirmationService,
    {provide: LOCALE_ID, useValue: 'pt-BR'}
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
