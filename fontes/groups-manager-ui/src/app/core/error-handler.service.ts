import { Injectable } from '@angular/core';
import { ToastyService } from 'ng2-toasty';

@Injectable()
export class ErrorHandlerService {

  constructor(private toasty: ToastyService) { }

  handle(errorResponse: any) {
    let msg: string;


    if (typeof errorResponse === 'string') {
      msg = errorResponse;
    } else {
      if (errorResponse.status >= 400 && errorResponse.status <= 499) {
        let body = JSON.parse(errorResponse._body)[0];
        msg = body.mensagemUsuario
        console.log('Ocorreu um erro: ', body.mensagemDesenvolvedor);
      } else {
        msg = `Erro ao processar serviço. Tente novamente.`;
        console.log('Ocorreu um erro: ', errorResponse);
      }
    }

    this.toasty.error(msg);
  }

}
