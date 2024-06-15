package com.bancodigital;
import java.util.Locale;
import java.util.Scanner;
import  cliente.Cliente;
import com.bancodigital.contas.ContaCorrente;
import com.bancodigital.contas.ContaPoupanca;
import com.bancodigital.emprestimo.CreditoPessoal;

public class Banco {

    public static void main(String[] args){


        demonstracao();

    }

    static void demonstracao() {
        Scanner sc = new Scanner(System.in);
        String escolha;
        Cliente jose = new Cliente("Jose","da Silva");
        Cliente ricardo = new Cliente("Ricardo", "Pinheiro");
        ContaCorrente contaJose = new ContaCorrente(jose);
        ContaCorrente contaRicardo = new ContaCorrente(ricardo);

        System.out.println("--------------DEMONSTRAÇÃO--------------");
        System.out.println("Iremos realizar uma demonstração das funcionalidades do Banco Digital!!");
        System.out.println("Nessa demonstração teremos o Jose e o Ricardo depositando, sacando, pedindo mais" +
                        "\ncrédito pessoal, pedindo empréstimo, guardando dinheiro na poupança e olhando o extrato.");

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("Vamos ver Jose depositando R500,00??");
        System.out.println();

        contaJose.depositar(500.0,false,"Deposito");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato?");
        System.out.println();
        contaJose.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar sacar R$200,00?");
        System.out.println();

        contaJose.sacar(200.0,false, "Saque");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato?");
        System.out.println();
        contaJose.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar sacar mais R$1000,00? Ele não tem esse saldo em conta...");
        System.out.println();

        contaJose.sacar(1000.0,false, "Saque");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato? Tem que estar igual!");
        System.out.println();
        contaJose.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar transferir R$100,00 para Ricardo?");
        System.out.println();
        contaJose.transferir(100.0, contaRicardo,"");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E como será que isso ficou no extrato de Ricardo?");
        System.out.println();
        contaRicardo.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar transferir mais R$900,00 para Ricardo? " +
                "\nEle não tem esse saldo em conta...");
        System.out.println();

        contaJose.transferir(900.0, contaRicardo, "");

        System.out.println();
        System.out.println("Como será que isso ficou no extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E como será que isso ficou no extrato de Ricardo?");
        System.out.println();
        contaRicardo.imprimirExtrato();

        System.out.println();
        System.out.println("Vamos ver as funcionalidades de crédito?? Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("Neste Banco todos começam com R$1000,00 de crédito!" +
                "\nAlém disso todos podem pedir mais crédito. Ao pedir mais crédito, é dado um valor a mais alatório" +
                "\nlimitado a R$50.000,00!" +
                "\nVamos ver o limite de Jose, imprimindo os dados do Cliente?");
        System.out.println();

        jose.imprimirDadosDoCliente();
        System.out.println();
        System.out.println("Vamos pedir mais crédito para Jose?");
        System.out.println();
        CreditoPessoal.pedirMaisCredito(jose);
        System.out.println("Vamos ver o novo limite de Jose, imprimindo os dados do Cliente?");
        jose.imprimirDadosDoCliente();

        System.out.println("Vamos ver o limite de Ricardo agora, imprimindo os dados do Cliente?");
        ricardo.imprimirDadosDoCliente();
        System.out.println();
        System.out.println("Vamos pedir mais crédito para Ricardo?");
        System.out.println();
        CreditoPessoal.pedirMaisCredito(ricardo);
        System.out.println("Vamos ver o novo limite de Ricardo, imprimindo os dados do Cliente?");
        ricardo.imprimirDadosDoCliente();

        System.out.println();
        System.out.println("Vamos pedir empréstimo?? Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("Jose vai pedir um empréstimo de R$1000,00. Vamos ver o que acontece!");
        System.out.println();
        contaJose.realizarEmprestimo(1000.00);
        System.out.println();
        System.out.println("E agora, como ficou o extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E o limite, será que consumiu? Vamos imprimir os dados de Jose");
        System.out.println();
        jose.imprimirDadosDoCliente();


        System.out.println();
        System.out.println("Só falta vermos a funcionalidade de guardar dinheiro na Poupança! " +
                "\nDeseja continuar? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        ContaPoupanca poupancaJose = new ContaPoupanca(jose);
        //jose.imprimirDadosDoCliente();
        System.out.println("Jose vai guardar R$1000,00 na poupança!");
        System.out.println();
        contaJose.guardarNaPoupanca(1000,poupancaJose);
        System.out.println();
        System.out.println("E agora, como ficou o extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E o extrato da conta poupança de Jose?");
        System.out.println();
        poupancaJose.imprimirExtrato();

        System.out.println("A demonstração acaba aqui! Obrigado!");

    }
}