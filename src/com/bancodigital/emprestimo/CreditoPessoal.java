package com.bancodigital.emprestimo;
import java.util.Random;
import cliente.Cliente;
//import com.bancodigital.contas.Conta;

public class CreditoPessoal {
    private static final int MAX_LIMITE = 50_000;
    private static final int MIN_LIMITE = 1_000;

   public static void pedirMaisCredito(Cliente cliente){
        Random rand = new Random();
        double limiteCliente = cliente.getLimiteDeCredito();
        if(limiteCliente < 50_000.00){
            double limiteAdicional = MIN_LIMITE + rand.nextInt(MAX_LIMITE - MIN_LIMITE);
            double novoLimite = limiteCliente + limiteAdicional;
            if (novoLimite > 50_000.00) novoLimite = 50_000.00;
            cliente.setLimiteDeCredito(novoLimite);
            System.out.printf("Seu novo limite é de R$%.2f !!\n", novoLimite);
        }else{
            System.out.println("Voce ja possui o limite máximo!");
        }
    }

}
