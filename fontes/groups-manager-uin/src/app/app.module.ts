import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpModule} from '@angular/http';

import {CoreModule} from './core/core.module';
import {GruposModule} from './grupos/grupos.module';
import {EventosModule} from './eventos/eventos.module';
import {IntegrantesModule} from './integrantes/integrantes.module';
import {GroupsRoutingModule} from './groups-routing.module';

import {AppComponent} from './app.component';
import {NoticiasModule} from './noticias/noticias.module';

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
    NoticiasModule,
    GroupsRoutingModule
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
