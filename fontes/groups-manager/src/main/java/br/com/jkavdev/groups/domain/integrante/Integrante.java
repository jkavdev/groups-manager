package br.com.jkavdev.groups.domain.integrante;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

    private String celular;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    @Column(name = "cadastro_efetivado")
    private Boolean cadastroEfetivado;

    private Integrante() {
    }

    public Integrante(String nome, String celular, String email, Sexo sexo, LocalDate dataNascimento, String cpf) {
        this(nome, dataNascimento.minus(Period.ofYears(LocalDate.now().getYear())).getYear());
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integrante(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public static Integrante empty() {
        Integrante empty = new Integrante();
        empty.nome = "";
        empty.celular = "";
        empty.email = "";
        empty.senha = "";
        empty.celular = "";
        empty.sexo = Sexo.MASCULINO;
        empty.cpf = "";
        empty.dataNascimento = LocalDate.now();
        empty.cadastroEfetivado = Boolean.FALSE;
        return empty;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getCadastroEfetivado() {
        return cadastroEfetivado;
    }

    public Integer getIdade() {
        return idade;
    }

    public void efetivarCadastro() {
        this.cadastroEfetivado = Boolean.TRUE;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("idade", idade)
                .append("email", email)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integrante that = (Integrante) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, cpf);
    }

    public static Integrante from(IntegranteDTO dto) {
        return new Integrante(dto.getNome(), dto.getIdade());
    }

    public static IntegranteDTO toDTO(Integrante integrante) {
        IntegranteDTO dto = new IntegranteDTO();
        dto.setNome(integrante.nome);
        dto.setIdade(integrante.idade);
        return dto;
    }
}
