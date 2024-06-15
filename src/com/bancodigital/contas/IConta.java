package com.bancodigital.contas;

public interface IConta {
    boolean sacar(double valor, boolean porTransferencia, String descricao);

    void depositar(double valor,boolean porTransferencia, String descricao);

    void transferir(double valor, Conta contaDestino, String descricao);

    void imprimirExtrato();

}
