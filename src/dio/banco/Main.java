package dio.banco;

import dio.banco.entities.Cliente;
import dio.banco.entities.Conta;
import dio.banco.entities.ContaCorrente;
import dio.banco.entities.ContaPoupanca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);


        System.out.print("Nome do cliente: ");
        String nomeCliente = scan.next();
        cliente.setNome(nomeCliente);

        System.out.println("Qual a conta que deseja depositar ?");
        System.out.println("1 - Conta Corrente\n2 - Conta Poupança");
        int escolherConta = scan.nextInt();

        if (escolherConta == 1){
            System.out.print("Qual o valor do depósito? ");
            double valorDeposito = scan.nextDouble();
            contaCorrente.depositar(valorDeposito);
        }
        else if (escolherConta == 2) {
            System.out.print("Qual o valor do depósito? ");
            double valorDeposito = scan.nextDouble();
            contaPoupanca.depositar(valorDeposito);
        }

        System.out.println();
        System.out.println("Gostaria de fazer tranferência?");
        System.out.println("1 - SIM\n2 - NÃO" );
        int transferencia = scan.nextInt();
        System.out.println();

        if (transferencia == 1){
            System.out.print("Digite o valor da Transferência: ");
            double valorTransferencia = scan.nextDouble();
            contaCorrente.transferir(valorTransferencia, contaPoupanca);

        }

        System.out.println();
        System.out.println("Segue o extrato das suas contas:");
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
        System.out.printf("");
        System.out.println("Obrigado pela preferência!");


    }
}
