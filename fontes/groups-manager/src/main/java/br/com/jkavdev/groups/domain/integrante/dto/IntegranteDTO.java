package br.com.jkavdev.groups.domain.integrante.dto;

import br.com.jkavdev.groups.domain.integrante.entity.Integrante;
import br.com.jkavdev.groups.domain.integrante.entity.Sexo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.time.Period;

import static java.time.LocalDate.now;

public class IntegranteDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private String celular;
    private String email;
    private String senha;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private String cpf;
    private Boolean cadastroEfetivado;

    public IntegranteDTO() {

    }

    public IntegranteDTO(Long id) {
        this.id = id;
    }

    public IntegranteDTO(Long id, String nome, Integer idade, String celular, Sexo sexo, String email,
                         LocalDate dataNascimento, String cpf, Boolean cadastroEfetivado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.celular = celular;
        this.email = email;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.cadastroEfetivado = cadastroEfetivado;
    }

    public static IntegranteDTO from(Integrante inte) {
        IntegranteDTO dto = new IntegranteDTO(inte.getId(), inte.getNome(), inte.getIdade(), inte.getCelular(),
                inte.getSexo(), inte.getEmail(), inte.getDataNascimento(), inte.getCpf(), inte.getCadastroEfetivado());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        if (idade == null) {
            int years = Period.between(dataNascimento, now()).getYears();
            if (years < 1)
                return 1;
            return years;
        }
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getCadastroEfetivado() {
        return cadastroEfetivado;
    }

    public void setCadastroEfetivado(Boolean cadastroEfetivado) {
        this.cadastroEfetivado = cadastroEfetivado;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("nome", nome)
                .append("idade", idade)
                .append("celular", celular)
                .append("email", email)
                .append("senha", senha)
                .append("sexo", sexo)
                .append("dataNascimento", dataNascimento)
                .append("cpf", cpf)
                .append("cadastroEfetivado", cadastroEfetivado)
                .toString();
    }
}
