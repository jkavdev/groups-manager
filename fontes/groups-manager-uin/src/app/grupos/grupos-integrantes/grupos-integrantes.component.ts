import { Component, OnInit } from '@angular/core';
import {Grupo} from '../../core/model';
import {ActivatedRoute} from '@angular/router';
import {GrupoService} from '../grupo.service';
import {ErrorHandlerService} from '../../core/error-handler.service';

@Component({
  selector: 'app-grupos-integrantes',
  templateUrl: './grupos-integrantes.component.html',
  styleUrls: ['./grupos-integrantes.component.css']
})
export class GruposIntegrantesComponent implements OnInit {

  grupo: Grupo = new Grupo();

  constructor(
    private route: ActivatedRoute,
    private grupoService: GrupoService,
    private errorHandler: ErrorHandlerService,
  ) {
  }

  ngOnInit() {
    const idGrupo = this.route.snapshot.params['id'];

    if (idGrupo) {
      this.buscarGrupo(idGrupo);
    }
  }

  buscarGrupo(codigo: number) {
    this.grupoService.comIntegrantes(codigo)
      .then(grupo => this.grupo = grupo)
      .catch(erro => this.errorHandler.handle(erro));
  }

}
