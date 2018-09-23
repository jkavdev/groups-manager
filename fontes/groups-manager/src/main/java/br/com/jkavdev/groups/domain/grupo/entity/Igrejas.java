package br.com.jkavdev.groups.domain.grupo.entity;

public enum  Igrejas {

    MENINO_DEUS("Menino Deus", 1L);

    private final String igreja;
    private final long id;

    Igrejas(String igreja, long id) {
        this.igreja = igreja;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getIgreja() {
        return igreja;
    }
}