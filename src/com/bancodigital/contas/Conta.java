package com.bancodigital.contas;
import  cliente.Cliente

public class Conta implements IConta{
    //atributos
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta (Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    //metodos
    @Override
    public void sacar(double valor) {
        if (saldo >= valor){
            saldo -= valor;
        }else{
            System.out.println("Não há saldo o suficiente para este saque!");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Foi depositado R$%.2f",valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {

    }

    @Override
    public void imprimirExtrato() {

    }
}
