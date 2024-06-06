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


}
