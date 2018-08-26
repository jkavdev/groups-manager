import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { GruposModule } from './grupos/grupos.module';
import { EventosModule } from './eventos/eventos.module';
import { IntegrantesModule } from './integrantes/integrantes.module';
import { NoticiasModule } from './noticias/noticias.module';
import { NoticiaPesquisaComponent } from './noticias/noticia-pesquisa/noticia-pesquisa.component';
import { NoticiaCadastroComponent } from './noticias/noticia-cadastro/noticia-cadastro.component';
import { GruposPesquisaComponent } from './grupos/grupos-pesquisa/grupos-pesquisa.component';
import { GruposCadastroComponent } from './grupos/grupos-cadastro/grupos-cadastro.component';
import { IntegrantePesquisaComponent } from './integrantes/integrante-pesquisa/integrante-pesquisa.component';
import { EventoCadastroComponent } from './eventos/evento-cadastro/evento-cadastro.component';
import { EventoPesquisaComponent } from './eventos/evento-pesquisa/evento-pesquisa.component';
import { IntegranteCadastroComponent } from './integrantes/integrante-cadastro/integrante-cadastro.component';
import { PaginaNaoEncontradaComponent } from './core/pagina-nao-encontrada.component';
import { GroupsRoutingModule } from './groups-routing.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    GroupsRoutingModule,

    CoreModule,
    EventosModule,
    GruposModule,
    IntegrantesModule,
    NoticiasModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [
    
  ]
})
export class AppModule { }
