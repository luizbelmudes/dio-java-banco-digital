package com.bancodigital;
import com.bancodigital.contas.Conta;
import  cliente.Cliente;
import com.bancodigital.contas.ContaCorrente;
import com.bancodigital.emprestimo.CreditoPessoal;

public class Banco {
    public static void main(String[] args){
        Cliente jose = new Cliente("Jose","da Silva");
        Cliente joao = new Cliente("Joao", "Pinheiro");
        ContaCorrente contaJose = new ContaCorrente(jose);
        ContaCorrente contaJoao = new ContaCorrente(joao);

        contaJose.depositar(500.0,false);
        contaJose.imprimirExtrato();

        contaJose.sacar(200.0,false);
        contaJose.imprimirExtrato();

        contaJose.sacar(1000.0,false);
        contaJose.imprimirExtrato();

        contaJose.transferir(100.0,contaJoao);
        contaJose.imprimirExtrato();
        contaJoao.imprimirExtrato();

        contaJose.transferir(900.0,contaJoao);
        contaJose.imprimirExtrato();
        contaJoao.imprimirExtrato();

        System.out.println("Limite de Credito do Jose: " +jose.getLimiteDeCredito());
        CreditoPessoal.pedirMaisCredito(jose);
        System.out.println("Limite de Credito do Jose: " +jose.getLimiteDeCredito());

        System.out.println("Limite de Credito do Joao: " +joao.getLimiteDeCredito());
        CreditoPessoal.pedirMaisCredito(joao);
        System.out.println("Limite de Credito do Joao: " +joao.getLimiteDeCredito());

        contaJose.realizarEmprestimo(70000.00);
        System.out.println("Limite de Credito do Jose: " +jose.getLimiteDeCredito());
        contaJose.imprimirExtrato();

        jose.imprimirDadosDoCliente();

    }
}
