package com.bancodigital.contas.transacoes;

import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;

public class Transacao {
    private static Calendar calendario  = Calendar.getInstance();

    private TiposTransacao tipoTransacao;
    private Date dataHoraTransacao;
    private double valorTransacao;
    private String descricaoTransacao;


    public Transacao(TiposTransacao tipoTransacao, double valorTransacao, String descricaoTransacao){
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.descricaoTransacao = descricaoTransacao;
        this.dataHoraTransacao = calendario.getTime();
    }
}
