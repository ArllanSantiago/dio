package org.asc.mockito.entidade;

import org.asc.mockito.shared.enums.Formato;

public class Email {
    private String remetente;
    private String destinatario;
    private String assunto;
    private String corpo;
    private Formato formato;

    public Email(String remetente, String destinatario, String assunto, String corpo, Formato formato ) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
        this.formato = formato;
    }

    // Métodos getter e setter para os atributos da classe

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}
