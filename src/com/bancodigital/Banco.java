package com.bancodigital;
import com.bancodigital.contas.Conta;
import  cliente.Cliente;
import com.bancodigital.contas.ContaCorrente;

public class Banco {
    public static void main(String[] args){
        Cliente jose = new Cliente("Jose","da Silva");
        Cliente joao = new Cliente("Joao", "Pinheiro");
        Conta contaJose = new ContaCorrente(jose);
        Conta contaJoao = new ContaCorrente(joao);

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
    }
}
