package org.asc.mockito;

import org.asc.mockito.entidade.Pedido;
import org.asc.mockito.shared.enums.SituacaoEnvio;
import org.asc.mockito.shared.enums.SituacaoPagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PedidoTeste {

    @Spy
    private Pedido pedido;

    @Test
    @DisplayName("CancelarPedido")
    void validarCancelarPedido(){

        var pedidoCanceladoMock = Mockito.mock(Pedido.class);

        pedidoCanceladoMock.cancelar();
        Mockito.when(pedidoCanceladoMock.getSituacaoEnvio()).thenReturn(SituacaoEnvio.CANCELADO);
        Mockito.when(pedidoCanceladoMock.getSituacaoPagamento()).thenReturn(SituacaoPagamento.CANCELADO);

        this.pedido.cancelar();
        Assertions.assertAll("pedido",
                () -> Assertions.assertEquals(pedidoCanceladoMock.getSituacaoEnvio(),this.pedido.getSituacaoEnvio()),
                () -> Assertions.assertEquals(pedidoCanceladoMock.getSituacaoPagamento(),this.pedido.getSituacaoPagamento())
                );

        Mockito.verify(this.pedido).modificarSituacaoEnvio(SituacaoEnvio.CANCELADO);
        Mockito.verify(this.pedido).modificarSituacaoPagamento(SituacaoPagamento.CANCELADO);

        InOrder inOrder = Mockito.inOrder(this.pedido);
        inOrder.verify(this.pedido).cancelar();
        inOrder.verify(this.pedido).modificarSituacaoEnvio(SituacaoEnvio.CANCELADO);
        inOrder.verify(this.pedido).modificarSituacaoPagamento(SituacaoPagamento.CANCELADO);

        Mockito.verify(this.pedido,Mockito.times(1)).modificarSituacaoEnvio(SituacaoEnvio.CANCELADO);
        Mockito.verify(this.pedido,Mockito.times(1)).modificarSituacaoPagamento(SituacaoPagamento.CANCELADO);

    }
}
