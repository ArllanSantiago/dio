package asc;

import jdk.jfr.Name;
import org.asc.entidades.Pessoa;
import org.asc.config.DbConfig;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaTest {

    private Logger logger  = Logger.getLogger(PessoaTest.class.getName());

    protected List<Pessoa> pessoas = new ArrayList<Pessoa>();
    protected Pessoa findByNomePessoaMock(String nome) {
        return pessoas.stream()
                .filter(pessoa -> nome.equals(pessoa.getNome()))
                .findFirst().stream().findAny()
                .orElseThrow(()-> new RuntimeException("PessoaMock nao Encontrada"));
    }

    @BeforeAll
    static void inicializarConexaoDb(){
        DbConfig.inicializarConexao();
    }

    @BeforeEach
    void adicionarDadosDeTeste(){
        logger.info("adicionarDadosDeTeste");
        this.pessoas= List.of(
                new Pessoa("Lorena", LocalDate.of(2018,05,14)),
                new Pessoa("Dayana", LocalDate.of(1993,11,3)),
                new Pessoa("Cleber",LocalDate.of(2022,1,1))
        );
    }

    @Test
    @Order(1)
    void validarCalculoIdade(){
        logger.info("validarCalculoIdade");
        Assertions.assertAll("pessoas",
                () -> Assertions.assertEquals(5, findByNomePessoaMock("Lorena").getIdade()),
                () -> Assertions.assertEquals(30, findByNomePessoaMock("Dayana").getIdade())
        );
    }

    @Test
    @Order(2)
    void validarMaiorIdade(){
        logger.info("validarMaiorIdade");
        Assertions.assertAll("pessoas",
                () -> Assertions.assertFalse(findByNomePessoaMock("Lorena").maiorIdade())
                ,() -> Assertions.assertTrue(findByNomePessoaMock("Dayana").maiorIdade())
        );
    }

    @Test
    @Order(3)
    void validarPessoasRegistradas(){
        logger.info("validarPessoasRegistradas");
        var pessoasRegistradas =  List.of(
                new Pessoa("Lorena", LocalDate.of(2018,05,14)),
                new Pessoa("Dayana", LocalDate.of(1993,11,3)),
                new Pessoa("Cleber",LocalDate.of(2022,1,1))
        );

        List<String> nomesReg = pessoasRegistradas.stream().map(pessoa -> pessoa.getNome()).collect(Collectors.toList());
        List<String> nomesOfTest = this.pessoas.stream().map(pessoa -> pessoa.getNome()).collect(Collectors.toList());

        Assertions.assertArrayEquals(nomesReg.toArray(),nomesOfTest.toArray(),"As pessoas que participal do teste não são as mesma - 1");
        Assertions.assertTrue(nomesOfTest.containsAll(nomesReg),"As pessoas que participal do teste não são as mesma - 2");
    }

    @Test
    @Order(4)
    void validarPessoaSemNome(){
        logger.info("validarPessoaSemNome");
        this.pessoas.forEach( pessoa -> {

            Assertions.assertAll("pessoas",
                    () -> Assertions.assertNotNull(pessoa.getNome(),"Pessoas cadastras sem nome - 1 ")
                    ,() -> Assertions.assertTrue(pessoa.getNome().length()> 0 , "Pessoas cadastras sem nome - 2 ")
            );
        });
    }


    @AfterEach
    void limparDadosDeTeste(){
        logger.info("limparDadosDeTeste");
        this.pessoas = new ArrayList<Pessoa>();
    }

    @AfterAll
    static void finalizarConexaoDb() throws InterruptedException {
        Thread.sleep(2000);
        DbConfig.finalizarConexao();
    }





}
