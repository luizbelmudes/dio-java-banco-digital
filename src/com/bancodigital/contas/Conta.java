package com.bancodigital.contas;
import  cliente.Cliente;

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
    public boolean sacar(double valor, boolean porTransferencia) {
        if (saldo >= valor){
            saldo -= valor;
            System.out.printf("Foi sacado R$%.2f com sucesso!\n",valor);
        }else{
            if(!porTransferencia) {
                System.out.println("Não há saldo o suficiente para este saque!");
            }else{
                System.out.println("Não há saldo o suficiente para esta transferência");
            }
            return false;
        }
        return true;
    }

    @Override
    public void depositar(double valor, boolean porTransferencia) {
        saldo += valor;
        if (!porTransferencia) System.out.printf("Foi depositado R$%.2f com sucesso!\n",valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if(sacar(valor, true))
            contaDestino.depositar(valor, true);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }
}
