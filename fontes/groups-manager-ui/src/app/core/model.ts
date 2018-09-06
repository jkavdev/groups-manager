export class Grupo {
  id: number;
  nome: string;
  igreja: string;
  objetivo: string;
  statusGrupoId: number;
  eventos: Evento[] = [];
}

export class StatusGrupo {
  id: number;
  nome: string;
  imageName: string;
  status: string;
  descricao: string;
}

export class Noticia {
  id: number;
  titulo: string;
  corpo: string;
  topicos = [];
  publica: boolean;
  grupo = new Grupo();
}

export class Endereco {
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
