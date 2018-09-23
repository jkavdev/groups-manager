export class Grupo {
  id: number;
  nome: string;
  igreja: string;
  objetivo: string;
  statusGrupoId: number;
  eventos: Evento[] = [];
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
  objetivo: string;
  valor: string;
  lotacaoMaxima: number;
  endereco = new Endereco();
  grupo: Grupo;
  grupoId: number;
}
