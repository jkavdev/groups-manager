import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  grupos = [
    { id: 1, imageName: 'Pastoral da criança', objetivo: 'Grupo de crianças', status: { status: 'PASTORAIS', imageName: 'PASTORAL_DO_DIZIMO' } },
    { id: 1, imageName: 'Pastoral da saúde', objetivo: 'Grupo de saúde', status: { status: 'PASTORAIS', imageName: 'PASTORAL_FAMILIAR' } },
    { id: 1, imageName: 'Pastoral da juventude', objetivo: 'Grupo de juventude', status: { status: 'PASTORAIS', imageName: 'PASTORAL_DA_CRIANCA' } },
    { id: 1, imageName: 'Encontro de Casais com Cristo', objetivo: 'Grupo de Casais', status: { status: 'MOVIMENTO', imageName: 'GAM' } },
    { id: 1, imageName: 'Apostolado da Oração', objetivo: 'Grupo de Oração', status: { status: 'MOVIMENTO', imageName: 'EJOC' } },
    { id: 1, imageName: 'Renovação Carismática Católica', objetivo: 'Grupo de Renovação', status: { status: 'MOVIMENTO', imageName: 'AJUC' } }
    ];

}
