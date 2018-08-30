package br.com.jkavdev.groups.domain.integrante;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class GruposIntegrantesDTO {

    private String grupo;
    private String integrante;
    private List<String> integrantes;

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getIntegrante() {
        return integrante;
    }

    public void setIntegrante(String integrante) {
        this.integrante = integrante;
    }

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
//                .append(grupo)
//                .append(integrante)
//                .toString();
//    }
}
