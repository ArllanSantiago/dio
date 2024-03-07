package org.asc.entidades;

public class Conta {

    private Integer conta;
    private Integer agencia;
    private Double saldo;

    private Pessoa pessoa;

    public Conta(Integer conta, Integer agencia, Double saldo, Pessoa pessoa) {
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.pessoa = pessoa;
    }

    public Integer getConta() {
        return conta;
    }

    private void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    private void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    private void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    private void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void sacar(Double valor ){
        if ( saldo - valor < 0 )
            throw new IllegalArgumentException("Saldo não Disponível");
        else if (valor < 0) {
            throw new IllegalArgumentException("Valor de Saque indisponível ");
        } else
            this.saldo -= valor;
    }

    public void deposito(Double valor){

        if (valor < 1.00 ) throw new IllegalArgumentException(" Valor do Deposito deve ser no minino de 1,00 ");

        this.saldo += valor;
    }

}
