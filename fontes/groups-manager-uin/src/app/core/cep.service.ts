import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Endereco, ViaCepEndereco} from './model';

@Injectable({
  providedIn: 'root'
})
export class CepService {

  viaCepUrl = 'https://viacep.com.br/ws';

  constructor(private http: Http) {
  }

  buscar(cep: string) {
    return this.http.get(`${this.viaCepUrl}/${cep}/json`)
      .toPromise()
      .then(resp => this.buildEndereco(resp.json()));
  }

  buildEndereco(endViaCep: ViaCepEndereco) {
    const endereco = new Endereco();
    endereco.bairro = endViaCep.bairro;
    endereco.cep = endViaCep.cep;
    endereco.complemento = endViaCep.complemento;
    endereco.logradouro = endViaCep.logradouro;
    endereco.localidade = endViaCep.localidade;
    endereco.uf = endViaCep.uf;
    endereco.unidade = endViaCep.unidade;
    return endereco;
  }
}
