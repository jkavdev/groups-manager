import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {CoreModule} from './core/core.module';
import {GruposModule} from './grupos/grupos.module';

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

    CoreModule,
    GruposModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
