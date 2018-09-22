import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {InputTextModule} from 'primeng/components/inputtext/inputtext';
import {ButtonModule} from 'primeng/components/button/button';
import {MultiSelectModule} from 'primeng/components/multiselect/multiselect';
import {EditorModule} from 'primeng/components/editor/editor';
import {DropdownModule} from 'primeng/components/dropdown/dropdown';
import {AccordionModule} from 'primeng/components/accordion/accordion';
import {CardModule} from 'primeng/components/card/card';
import {ToggleButtonModule} from 'primeng/components/togglebutton/togglebutton';
import {TooltipModule} from 'primeng/components/tooltip/tooltip';
import {FieldsetModule} from 'primeng/components/fieldset/fieldset';
import {ToastModule} from 'primeng/components/toast/toast';

import {NoticiasPesquisaComponent} from './noticias-pesquisa/noticias-pesquisa.component';
import {NoticiasCadastroComponent} from './noticias-cadastro/noticias-cadastro.component';

@NgModule({
  imports: [
    CommonModule,

    ButtonModule,
    InputTextModule,
    EditorModule,
    MultiSelectModule,
    DropdownModule,
    AccordionModule,
    CardModule,
    TooltipModule,
    ToggleButtonModule,
    FieldsetModule,
    ToastModule
  ],
  declarations: [
    NoticiasPesquisaComponent,
    NoticiasCadastroComponent
  ],
  exports: [
    NoticiasPesquisaComponent,
    NoticiasCadastroComponent
  ]
})
export class NoticiasModule {
}
