package org.asc.mockito.shared.enums;

public enum SituacaoPagamento {

    PENDENTE("Pedente",1),
    PROCESSANDO("Processando",2),
    CANCELADO("Cancelado",3),
    REJEITADO("Rejeitado", 4),
    APROVADO("Aprovado",5);

    private final String descricao;
    private final Integer valor;

    SituacaoPagamento(String descricao, Integer valor) {
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
