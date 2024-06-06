package com.bancodigital.contas;

import  cliente.Cliente;
import com.bancodigital.emprestimo.Emprestimo;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

    public void realizarEmprestimo (double valorDoEmprestimo){
        Emprestimo.realizarEmprestimo(this,valorDoEmprestimo);
    }

    public void guardarNaPoupanca(double valorParaGuardar, Conta contaPoupanca){
        if(contaPoupanca instanceof ContaPoupanca){
            this.transferir(valorParaGuardar,contaPoupanca);

        }else{
            System.out.println("Esta conta não é poupança! Necessário que seja uma conta poupança");
        }
    }

}
