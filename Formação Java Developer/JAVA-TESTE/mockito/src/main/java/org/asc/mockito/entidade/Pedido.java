package org.asc.mockito.entidade;

import org.asc.mockito.shared.enums.SituacaoEnvio;
import org.asc.mockito.shared.enums.SituacaoPagamento;

public class Pedido {

    private long id;
    private SituacaoEnvio situacaoEnvio = SituacaoEnvio.PENDENTE;
    private SituacaoPagamento situacaoPagamento = SituacaoPagamento.PENDENTE;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SituacaoEnvio getSituacaoEnvio() {
        return situacaoEnvio;
    }

    public Pedido(long id, SituacaoEnvio situacaoEnvio, SituacaoPagamento situacaoPagamento) {
        this.id = id;
        this.situacaoEnvio = situacaoEnvio;
        this.situacaoPagamento = situacaoPagamento;
    }

    public Pedido(){};

    public void setSituacaoEnvio(SituacaoEnvio situacaoEnvio) {
        this.situacaoEnvio = situacaoEnvio;
    }

    public SituacaoPagamento getSituacaoPagamento() {
        return situacaoPagamento;
    }

    public void setSituacaoPagamento(SituacaoPagamento situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    public void modificarSituacaoEnvio(SituacaoEnvio situacaoEnvio){
        this.situacaoEnvio = situacaoEnvio;
    }

    public void modificarSituacaoPagamento(SituacaoPagamento situacaoPagamento){
        this.situacaoPagamento = situacaoPagamento;
    }


    public void cancelar() {
        this.modificarSituacaoEnvio(SituacaoEnvio.CANCELADO);
        this.modificarSituacaoPagamento(SituacaoPagamento.CANCELADO);

    }
}
