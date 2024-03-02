import java.util.Arrays;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
       
        Scanner scanner = new Scanner(System.in);
        var charHeader = '=';
        var charAtribuuto ='-';
        var charSize = 50;


        System.out.println("[Cadastro de Conta Bancária]");
        System.out.println(ReplicarCaractere(charHeader,charSize));  
        System.out.printf("[I] Por favor, digite o número da Conta : ");       
        int Numero = scanner.nextInt();

        System.out.println(ReplicarCaractere(charAtribuuto,charSize)); 
        scanner.nextLine();
        System.out.printf("[II] Por favor, digite o número da Agência: ");       
        String Agencia= scanner.nextLine();
   
        System.out.println(ReplicarCaractere(charAtribuuto,charSize)); 
        System.out.printf("[III] Por favor, digite o seu Nome : ");       
        String NomeCliente = scanner.nextLine();
        
        System.out.println(ReplicarCaractere(charAtribuuto,charSize)); 
        System.out.printf("[IV] Por favor, digite o Saldo : ");       
        Double Saldo = scanner.nextDouble();
        
        var msgSucess = String.format(" Olá %s, obrigado por criar uma conta em nosso banco, \n"  //                        
                       +"sua agência é %s, conta %s e seu saldo %s \n"
                       +"já está disponível para saque", NomeCliente,Agencia,Numero,Saldo);

        System.out.println(ReplicarCaractere(charHeader,charSize)); 
        System.out.println(msgSucess);
        System.out.println(ReplicarCaractere(charHeader,charSize)); 
    }

    public static String ReplicarCaractere(char caractere , int size) {
        var arrCaracteres = new char[size];
        Arrays.fill(arrCaracteres, caractere);
        return new String (arrCaracteres);
    }
}
