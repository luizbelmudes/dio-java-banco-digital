package com.bancodigital.emprestimo;

import cliente.Cliente;
import com.bancodigital.contas.Conta;

public class Emprestimo {
    public static void realizarEmprestimo(Conta contaCliente, double valorDoEmprestimo){
        Cliente cliente = contaCliente.getCliente();
        double limiteDoCliente = cliente.getLimiteDeCredito();
        if (limiteDoCliente >= valorDoEmprestimo){
            cliente.setLimiteDeCredito(limiteDoCliente - valorDoEmprestimo);
            contaCliente.depositar(valorDoEmprestimo, false);
        }else{
            System.out.println("Nao há limite o suficiente para este empréstimo!");
        }
    }
}
