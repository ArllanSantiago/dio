package asc;

import org.asc.entidades.Conta;
import org.asc.entidades.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContaTest {

    protected Conta conta;

    @BeforeEach
    void inicializarDadoDeTeste(){
        var joana = new Pessoa("Joana", LocalDate.of(2000,07,30));
        conta = new Conta(50987,2445,15000.00,joana);
    }

    @Test
    void validarDeposito(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> this.conta.deposito(-90.00));

    }

    @Test
    void validarSaque(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> this.conta.sacar(20000.00));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> this.conta.sacar(-90.00));
    }
}
