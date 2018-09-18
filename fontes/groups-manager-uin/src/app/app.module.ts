import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {InputTextModule} from 'primeng/components/inputtext/inputtext';
import {ButtonModule} from 'primeng/components/button/button';
import {DataViewModule} from 'primeng/components/dataview/dataview';
import {PanelModule} from 'primeng/components/panel/panel';
import {TooltipModule} from 'primeng/components/tooltip/tooltip';
import {MegaMenuModule} from 'primeng/components/megamenu/megamenu';
import {TieredMenuModule} from 'primeng/components/tieredmenu/tieredmenu';
import {MenuItem} from 'primeng/api';

import {AppComponent} from './app.component';
import {GruposPesquisaComponent} from './grupos/grupos-pesquisa/grupos-pesquisa.component';
import {NavbarComponent} from './core/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    GruposPesquisaComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,

    InputTextModule,
    ButtonModule,
    DataViewModule,
    PanelModule,
    TooltipModule,
    MegaMenuModule,
    TieredMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
