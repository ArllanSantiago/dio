package org.asc.mockito.servico;

import org.asc.mockito.config.PlataformaDeEnvio;
import org.asc.mockito.entidade.Email;
import org.asc.mockito.shared.enums.Formato;


public class ServicoEnvioEmail {
    private PlataformaDeEnvio plataformaDeEnvio;

    public void enviarEmail(String remetente,String destinatario, String assunto, String corpo , boolean formatoHtml){
        Email email = new Email(remetente,destinatario, assunto, corpo, formatoHtml ?Formato.HTML: Formato.TEXTO);

        plataformaDeEnvio.enviarEmail(email);
    }
}
