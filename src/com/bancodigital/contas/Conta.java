package com.bancodigital.contas;

import  cliente.Cliente;
import com.bancodigital.contas.transacoes.*;
import java.util.ArrayList;
import java.util.List;

public class Conta implements IConta{
    //atributos
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes;

    public Conta (Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    //metodos
    @Override
    public boolean sacar(double valor, boolean porTransferencia, String descricao) {
        if (saldo >= valor){
            saldo -= valor;
            if (!porTransferencia) {
                System.out.printf("Foi sacado R$%.2f com sucesso!\n", valor);
                transacoes.add(new Transacao(TiposTransacao.SAQUE, valor, descricao));
            }
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
    public void depositar(double valor, boolean porTransferencia, String descricao) {
        saldo += valor;
        if (!porTransferencia) {
            System.out.printf("Foi depositado R$%.2f com sucesso!\n", valor);
        }
        transacoes.add(new Transacao(TiposTransacao.DEPOSITO, valor, descricao));
    }

    @Override
    public void transferir(double valor, Conta contaDestino, String descricao) {
        if(sacar(valor, true, "")) {
            String descricaoEfetivaDeposito;
            String descricaoEfetivaTransacao;
            if (descricao.isEmpty()){
                descricaoEfetivaDeposito = "Transferência de " +  cliente.getNome() + " " + cliente.getSobrenome();
                descricaoEfetivaTransacao = "Transferência para "+  contaDestino.cliente.getNome() + " " + contaDestino.cliente.getSobrenome();
            }else{
                descricaoEfetivaDeposito = descricao;
                descricaoEfetivaTransacao = descricao;
            }
            contaDestino.depositar(valor, true, descricaoEfetivaDeposito);
            transacoes.add(new Transacao(TiposTransacao.TRANSFERECIA,valor,descricaoEfetivaTransacao));
        }
    }

    @Override
    public void imprimirExtrato() {
        //System.out.println(this.toString());
        System.out.println("-----------EXTRATO-------------");
        System.out.println("NOME CLIENTE: " +  cliente.getNome() + " " + cliente.getSobrenome());
        System.out.println("AGENCIA: " + agencia);
        System.out.println("CONTA: " + numero);
        System.out.printf("SALDO EM CONTA: R$%.2f\n", saldo);
        System.out.println("-TRANSACAO----|---VALOR----|----------DATA-E-HORA----------|---------------DESCRICAO---------------|");
        for(Transacao t : transacoes){
            switch(t.getTipoTransacao()) {
                case TiposTransacao.TRANSFERECIA:
                    System.out.print("Transferência...");
                    break;
                case TiposTransacao.SAQUE:
                    System.out.print("Saque...........");
                    break;
                case TiposTransacao.DEPOSITO:
                    System.out.print("Deposito........");
            }

            System.out.printf("R$%.2f", t.getValorTransacao());
            System.out.println("....." + t.getDataHoraTransacao() + "....." + t.getDescricaoTransacao());

        }
        System.out.println("-----------FIM EXTRATO---------");
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

    public Cliente getCliente() {
        return cliente;
    }
}
