package com.bancodigital;
import com.bancodigital.contas.Conta;
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
        String delay;
        Cliente jose = new Cliente("Jose","da Silva");
        Cliente joao = new Cliente("Joao", "Pinheiro");
        ContaCorrente contaJose = new ContaCorrente(jose);
        ContaCorrente contaJoao = new ContaCorrente(joao);

        contaJose.depositar(500.0,false,"Deposito");
        contaJose.imprimirExtrato();

        delay = sc.next();

        contaJose.sacar(200.0,false, "Saque");
        contaJose.imprimirExtrato();

        delay = sc.next();

        contaJose.sacar(1000.0,false, "Saque");
        contaJose.imprimirExtrato();

        delay = sc.next();

        contaJose.transferir(100.0,contaJoao,"");
        contaJose.imprimirExtrato();
        contaJoao.imprimirExtrato();

        delay = sc.next();

        contaJose.transferir(900.0,contaJoao, "");
        contaJose.imprimirExtrato();
        contaJoao.imprimirExtrato();

        delay = sc.next();

        System.out.println("Limite de Credito do Jose: " +jose.getLimiteDeCredito());
        CreditoPessoal.pedirMaisCredito(jose);
        System.out.println("Limite de Credito do Jose: " +jose.getLimiteDeCredito());

        System.out.println("Limite de Credito do Joao: " +joao.getLimiteDeCredito());
        CreditoPessoal.pedirMaisCredito(joao);
        System.out.println("Limite de Credito do Joao: " +joao.getLimiteDeCredito());

        delay = sc.next();

        contaJose.realizarEmprestimo(10000.00);
        System.out.println("Limite de Credito do Jose: " +jose.getLimiteDeCredito());
        contaJose.imprimirExtrato();

        delay = sc.next();

        ContaPoupanca poupancaJose = new ContaPoupanca(jose);
        jose.imprimirDadosDoCliente();
        contaJose.guardarNaPoupanca(1000,poupancaJose);
        contaJose.imprimirExtrato();
        poupancaJose.imprimirExtrato();
    }
}