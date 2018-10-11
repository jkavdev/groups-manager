export class Grupo {
  id: number;
  nome: string;
  igreja: string;
  objetivo: string;
  statusGrupoId: number;
  eventos: Evento[] = [];
  integrantes: Integrante[] = [];
}

export class Endereco {
  id: number;
  cep: string;
  logradouro: string;
  complemento: string;
  bairro: string;
  localidade: string;
  uf: string;
  unidade: string;
}

export class ViaCepEndereco {
  gia: string;
  ibge: string;
  cep: string;
  logradouro: string;
  complemento: string;
  bairro: string;
  localidade: string;
  uf: string;
  unidade: string;
}

export class Evento {
  data: Date;
  descricao: string;
  motivo: string;
  objetivo: string;
  valor: string;
  lotacaoMaxima: number;
  endereco = new Endereco();
  grupo: Grupo;
  grupoId: number;
}

export class Integrante {
  nome: string;
  celular: string;
  idade: number;
  email: string;
  senha: string;
  sexo: string;
  dataNascimento: Date;
  cpf: string;
  membroOutraIgreja: boolean;
  membroDaIgreja: boolean;
  nomeDaOutraIgreja: string;
  cadastroEfetivado: boolean;
}
