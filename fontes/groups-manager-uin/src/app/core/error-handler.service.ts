import {Injectable} from '@angular/core';

import {MessageService} from 'primeng/api';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {

  constructor(private messageService: MessageService) {
  }

  handle(errorResponse: any) {
    let msg: string;

    if (typeof errorResponse === 'string') {
      msg = errorResponse;
    } else {
      // verificando se a resposta eh do tipo erro
      if (errorResponse.status >= 400 && errorResponse.status <= 499) {
        const body = JSON.parse(errorResponse._body)[0];
        msg = body.mensagemUsuario;
        console.log('Ocorreu um erro: ', body.mensagemDesenvolvedor);
      } else {
        msg = `Erro ao processar serviço. Tente novamente.`;
        console.log('Ocorreu um erro: ', errorResponse);
      }
    }
    this.messageService.add({severity: 'error', summary: `Erro!`, detail: msg});
  }
}
