package com.bancodigital.contas;

public class Conta implements IConta{
    //atributos
    private int agencia;
    private int numero;
    
    //metodos
    @Override
    public void sacar(double valor) {

    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public void transferir(double valor, IConta contaDestino) {

    }

    @Override
    public void imprimirExtrato() {

    }
}
