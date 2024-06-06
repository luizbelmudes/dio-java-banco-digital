package com.bancodigital.contas;

public interface IConta {
    boolean sacar(double valor, boolean porTransferencia);

    void depositar(double valor,boolean porTransferencia);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();

}
