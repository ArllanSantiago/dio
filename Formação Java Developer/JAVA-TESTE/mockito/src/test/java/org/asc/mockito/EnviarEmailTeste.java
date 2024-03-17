package org.asc.mockito;

import org.asc.mockito.config.PlataformaDeEnvio;
import org.asc.mockito.entidade.Email;
import org.asc.mockito.servico.ServicoEnvioEmail;
import org.asc.mockito.shared.enums.Formato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarEmailTeste {

    @Mock
    private PlataformaDeEnvio plataformaDeEnvio;

    @InjectMocks
    private ServicoEnvioEmail servicoEnvioEmail;

    @Captor
    private ArgumentCaptor<Email> captorEnvioEmail;
    @Test
    void validarDadosEnviadosParaPlataforma(){

         String remetente = "testando123@teste.com.br";
         String destinatario = "testando@teste.com.br";
         String assunto = "TESTANDO";
         String corpo = "ping...";
         Boolean ehFormatoHtml = false;

         servicoEnvioEmail.enviarEmail(
                 remetente
                 ,destinatario
                 ,assunto
                 ,corpo
                 ,ehFormatoHtml
         );

        Mockito.verify(this.plataformaDeEnvio).enviarEmail(captorEnvioEmail.capture());

        Email dadosCapturados = captorEnvioEmail.getValue();
        Assertions.assertEquals(remetente, dadosCapturados.getRemetente() );
        Assertions.assertEquals(destinatario, dadosCapturados.getDestinatario() );
        Assertions.assertEquals(assunto, dadosCapturados.getAssunto() );
        Assertions.assertEquals(corpo, dadosCapturados.getCorpo() );
        Assertions.assertEquals(Formato.TEXTO, dadosCapturados.getFormato() );
    }
}
