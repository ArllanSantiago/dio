package org.asc.mockito.shared.enums;

public enum SituacaoEnvio {
    PENDENTE("Pendente",1),
    ENVIADO("Enviado",2),
    CANCELADO("Cancelado",3),
    ENTREGUE("Entregue",4);


    private final String descricao;
    private final Integer valor;

    SituacaoEnvio(String descricao, Integer valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getValor() {
        return valor;
    }
}
