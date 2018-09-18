import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {InputTextModule} from 'primeng/components/inputtext/inputtext';
import {ButtonModule} from 'primeng/components/button/button';
import {DataViewModule} from 'primeng/components/dataview/dataview';
import {PanelModule} from 'primeng/components/panel/panel';
import {TooltipModule} from 'primeng/components/tooltip/tooltip';
import {MegaMenuModule} from 'primeng/components/megamenu/megamenu';
import {TieredMenuModule} from 'primeng/components/tieredmenu/tieredmenu';
import {DropdownModule} from 'primeng/components/dropdown/dropdown';
import {InputTextareaModule} from 'primeng/components/inputtextarea/inputtextarea';
import {MessageModule} from 'primeng/components/message/message';
import {ToastModule} from 'primeng/components/toast/toast';

import {AppComponent} from './app.component';
import {NavbarComponent} from './core/navbar/navbar.component';
import {GruposPesquisaComponent} from './grupos/grupos-pesquisa/grupos-pesquisa.component';
import {GruposCadastroComponent} from './grupos/grupos-cadastro/grupos-cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    GruposPesquisaComponent,
    NavbarComponent,
    GruposCadastroComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,

    InputTextModule,
    ButtonModule,
    DataViewModule,
    PanelModule,
    TooltipModule,
    MegaMenuModule,
    TieredMenuModule,
    DropdownModule,
    InputTextareaModule,
    MessageModule,
    ToastModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
