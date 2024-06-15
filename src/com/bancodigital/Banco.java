package com.bancodigital;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import  cliente.Cliente;
import com.bancodigital.contas.Conta;
import com.bancodigital.contas.ContaCorrente;
import com.bancodigital.contas.ContaPoupanca;
import com.bancodigital.emprestimo.CreditoPessoal;

public class Banco {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();
        String nomeLogado;
        String sobrenomeLogado;
        System.out.println("Bem-vindo ao Banco Digital DIO!!");
        System.out.println();

        System.out.print("Digite seu primeiro nome e pressione Enter:");

        nomeLogado = sc.next();

        System.out.print("Digite seu sobrenome e pressione Enter:");

        sobrenomeLogado = sc.next();

        Cliente clienteLogado = new Cliente(nomeLogado, sobrenomeLogado);


        int opcaoCliente;
        do {
            System.out.println("Escolha sua opção dentre as abaixo:");
            System.out.println("1 - Demonstração de Funcionalidades");
            System.out.println("2 - Logar em uma Conta");
            System.out.println("3 - Criar Conta Corrente");
            System.out.println("4 - Criar Conta Poupanca");
            System.out.println("0 - Sair");

            System.out.print("Digite sua opção e pressione Enter:");

            opcaoCliente = sc.nextInt();
            System.out.println();

            switch (opcaoCliente){
                case 0:
                    System.out.println("Obrigado e volte sempre!! :)");
                    break;
                case 1:
                    demonstracao();
                    break;
                case 2:
                    logarEmConta(contas);
                    break;
                case 3:
                    contas.add(criarConta(0, clienteLogado));
                    break;
                case 4:
                    contas.add(criarConta(1, clienteLogado));
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!!");
            }

        }while (opcaoCliente != 0);


    }

    static void logarEmConta(List<Conta> contasDoCliente){
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Scanner scanPausa = new Scanner(System.in);
        if(contasDoCliente.isEmpty()){
            System.out.println("Você ainda não possui contas. Volte ao Menu e crie uma Conta!!");
            System.out.println("Pressione enter para voltar.");
            sc.nextLine();
            return;
        }
        int opcaoDoUsuario;
        do {
            System.out.println("Selecione a conta que deseja logar:");
            for (int i = 0; i < contasDoCliente.size(); i++) {
                Conta contaTemp = contasDoCliente.get(i);
                if (contaTemp instanceof ContaCorrente) {
                    System.out.print((i+1) + " -> Conta Corrente");
                } else {
                    System.out.print((i+1) + " -> Conta Poupança");
                }
                System.out.println(" - Agencia: " + contaTemp.getAgencia() + " Número: "
                        + contaTemp.getNumero());

            }
            System.out.println("0 -> Voltar");
            System.out.print("Digite a opção e pressione Enter:");
            opcaoDoUsuario = sc.nextInt() - 1;
            if(opcaoDoUsuario == -1) return;
            else if (opcaoDoUsuario >= contasDoCliente.size() || opcaoDoUsuario < 0){
                opcaoDoUsuario = -1;
            }
        } while (opcaoDoUsuario == -1);


            Conta contaEscolhida = contasDoCliente.get(opcaoDoUsuario);
            boolean isCorrente = (contaEscolhida instanceof ContaCorrente);
        do {
            System.out.println("Escolha sua opção dentre as abaixo:");
            System.out.println("1 - Consultar Extrato");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Meus Dados e Limite");
            System.out.println("6 - Pedir mais Limite");
            if(isCorrente)System.out.println("7 - Realizar Empréstimo");
            if(isCorrente)System.out.println("8 - Guardar na Poupança");
            System.out.println("0 - Voltar");

            System.out.print("Digite sua opção e pressione Enter:");

            opcaoDoUsuario = sc.nextInt();
            System.out.println();
            switch (opcaoDoUsuario){
                case 0:
                    break;
                case 1:
                    System.out.println();
                    contaEscolhida.imprimirExtrato();
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Digite o valor que deseja depositar: ");
                    double valorDeposito = sc.nextDouble();
                    contaEscolhida.depositar(valorDeposito,false,"Deposito em Dinheiro");
                    System.out.println();
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Digite o valor que deseja sacar: ");
                    double valorSaque = sc.nextDouble();
                    contaEscolhida.sacar(valorSaque,false,"Saque em Dinheiro");
                    System.out.println();
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                case 4:
                    System.out.println();
                    System.out.print("Digite o valor que deseja transdferir: ");
                    double valorTransferencia = sc.nextDouble();
                    System.out.println();
                    Conta contaTransferencia = selecionarConta(contasDoCliente, true, contaEscolhida);
                    if(contaTransferencia == null) break;
                    contaEscolhida.transferir(valorTransferencia,contaTransferencia,"");
                    System.out.println();
                    System.out.printf("Valor de R$%.2f transferido com sucesso!!", valorTransferencia);
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                case 5:
                    System.out.println();
                    contaEscolhida.getCliente().imprimirDadosDoCliente();
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                case 6:
                    System.out.println();
                    CreditoPessoal.pedirMaisCredito(contaEscolhida.getCliente());
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                case 7:
                    if(!isCorrente){
                        System.out.println("OPÇÃO INVÁLIDA!!");
                        break;
                    }
                    System.out.println();
                    System.out.print("Digite o valor que deseja realizar de empréstimo: ");
                    double valorEmprestimo = sc.nextDouble();
                    System.out.println();
                    ((ContaCorrente) contaEscolhida).realizarEmprestimo(valorEmprestimo);
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                case 8:
                    if(!isCorrente){
                        System.out.println("OPÇÃO INVÁLIDA!!");
                        break;
                    }
                    System.out.println();
                    System.out.print("Digite o valor que deseja guardar na Poupança: ");
                    double valorPoupanca = sc.nextDouble();
                    System.out.println();
                    Conta contaPoupanca = selecionarConta(contasDoCliente, false, contaEscolhida);
                    if(contaPoupanca == null) break;
                    ((ContaCorrente) contaEscolhida).guardarNaPoupanca(valorPoupanca,contaPoupanca);
                    System.out.println();
                    System.out.printf("Valor de R$%.2f guardado com sucesso!!", valorPoupanca);
                    System.out.println("Pressione enter para voltar.");
                    scanPausa.nextLine();
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!!");
            }

        } while (opcaoDoUsuario != 0);
    }

    static Conta selecionarConta(List<Conta> contas, boolean isCorrente, Conta contaAtual){
        List<Conta> listaDeContaTemp = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner scanPause = new Scanner(System.in);
        for(Conta c : contas){
            if(c == contaAtual) continue;
            if(isCorrente){
                if (c instanceof ContaCorrente) listaDeContaTemp.add(c);
            }else{
                if (c instanceof ContaPoupanca) listaDeContaTemp.add(c);
            }
        }
        if(listaDeContaTemp.isEmpty()) {

            if(!isCorrente)System.out.println("Você não possui nenhuma conta Poupança. Crie para guardar!");
            else System.out.println("Nenhuma conta Corrente encontrada!");
            System.out.println();
            System.out.println("Pressione enter para voltar.");
            scanPause.nextLine();
            return null;
        }


        int opcaoDoUsuario;
        do {
            System.out.println("Selecione a conta:");
            for (int i = 0; i < listaDeContaTemp.size(); i++) {
                Conta contaTemp = listaDeContaTemp.get(i);
                if (contaTemp instanceof ContaCorrente) {
                    System.out.print((i+1) + " -> Conta Corrente");
                } else {
                    System.out.print((i+1) + " -> Conta Poupança");
                }
                System.out.println(" - Agencia: " + contaTemp.getAgencia() + " Número: "
                        + contaTemp.getNumero());

            }
            System.out.println("0 -> Voltar");
            System.out.print("Digite a opção e pressione Enter:");
            opcaoDoUsuario = sc.nextInt() - 1;
            if(opcaoDoUsuario == -1) return null;
            else if (opcaoDoUsuario >= listaDeContaTemp.size() || opcaoDoUsuario < 0){
                opcaoDoUsuario = -1;
            }
        } while (opcaoDoUsuario == -1);

        return listaDeContaTemp.get(opcaoDoUsuario);

    }
    static Conta criarConta(int tipo, Cliente cliente){
        Scanner sc = new Scanner(System.in);
        Conta contaTemp;
        if(tipo == 0){
            contaTemp = new ContaCorrente(cliente);
            System.out.println();
            System.out.println("Sua nova Conta Corrente é:" +
                    "\nAgencia: " +contaTemp.getAgencia() +
                    "\nNumero: " +contaTemp.getNumero());
            System.out.println();
        }else {
            contaTemp = new ContaPoupanca(cliente);
            System.out.println();
            System.out.println("Sua nova Conta Poupança é:" +
                    "\nAgencia: " + contaTemp.getAgencia() +
                    "\nNumero: " + contaTemp.getNumero());
            System.out.println();
        }
        System.out.println("Pressione enter para voltar.");
        sc.nextLine();
        return contaTemp;
    }


    static void demonstracao() {
        Scanner sc = new Scanner(System.in);
        String escolha;
        Cliente jose = new Cliente("Jose","da Silva");
        Cliente ricardo = new Cliente("Ricardo", "Pinheiro");
        ContaCorrente contaJose = new ContaCorrente(jose);
        ContaCorrente contaRicardo = new ContaCorrente(ricardo);

        System.out.println("--------------DEMONSTRAÇÃO--------------");
        System.out.println("Iremos realizar uma demonstração das funcionalidades do Banco Digital DIO!!");
        System.out.println("Nessa demonstração teremos o Jose e o Ricardo depositando, sacando, pedindo mais" +
                        "\ncrédito pessoal, pedindo empréstimo, guardando dinheiro na poupança e olhando o extrato.");

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("Vamos ver Jose depositando R500,00??");
        System.out.println();

        contaJose.depositar(500.0,false,"Deposito");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato?");
        System.out.println();
        contaJose.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar sacar R$200,00?");
        System.out.println();

        contaJose.sacar(200.0,false, "Saque");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato?");
        System.out.println();
        contaJose.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar sacar mais R$1000,00? Ele não tem esse saldo em conta...");
        System.out.println();

        contaJose.sacar(1000.0,false, "Saque");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato? Tem que estar igual!");
        System.out.println();
        contaJose.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar transferir R$100,00 para Ricardo?");
        System.out.println();
        contaJose.transferir(100.0, contaRicardo,"");
        System.out.println();
        System.out.println("Como será que isso ficou no extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E como será que isso ficou no extrato de Ricardo?");
        System.out.println();
        contaRicardo.imprimirExtrato();

        System.out.println();
        System.out.println("Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("E agora se josé tentar transferir mais R$900,00 para Ricardo? " +
                "\nEle não tem esse saldo em conta...");
        System.out.println();

        contaJose.transferir(900.0, contaRicardo, "");

        System.out.println();
        System.out.println("Como será que isso ficou no extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E como será que isso ficou no extrato de Ricardo?");
        System.out.println();
        contaRicardo.imprimirExtrato();

        System.out.println();
        System.out.println("Vamos ver as funcionalidades de crédito?? Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("Neste Banco todos começam com R$1000,00 de crédito!" +
                "\nAlém disso todos podem pedir mais crédito. Ao pedir mais crédito, é dado um valor a mais alatório" +
                "\nlimitado a R$50.000,00!" +
                "\nVamos ver o limite de Jose, imprimindo os dados do Cliente?");
        System.out.println();

        jose.imprimirDadosDoCliente();
        System.out.println();
        System.out.println("Vamos pedir mais crédito para Jose?");
        System.out.println();
        CreditoPessoal.pedirMaisCredito(jose);
        System.out.println("Vamos ver o novo limite de Jose, imprimindo os dados do Cliente?");
        jose.imprimirDadosDoCliente();

        System.out.println("Vamos ver o limite de Ricardo agora, imprimindo os dados do Cliente?");
        ricardo.imprimirDadosDoCliente();
        System.out.println();
        System.out.println("Vamos pedir mais crédito para Ricardo?");
        System.out.println();
        CreditoPessoal.pedirMaisCredito(ricardo);
        System.out.println("Vamos ver o novo limite de Ricardo, imprimindo os dados do Cliente?");
        ricardo.imprimirDadosDoCliente();

        System.out.println();
        System.out.println("Vamos pedir empréstimo?? Deseja seguir com a demonstração? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        System.out.println("Jose vai pedir um empréstimo de R$1000,00. Vamos ver o que acontece!");
        System.out.println();
        contaJose.realizarEmprestimo(1000.00);
        System.out.println();
        System.out.println("E agora, como ficou o extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E o limite, será que consumiu? Vamos imprimir os dados de Jose");
        System.out.println();
        jose.imprimirDadosDoCliente();


        System.out.println();
        System.out.println("Só falta vermos a funcionalidade de guardar dinheiro na Poupança! " +
                "\nDeseja continuar? y/n");
        escolha = sc.next();
        if(!escolha.toLowerCase(Locale.ROOT).equals("y")) return;

        ContaPoupanca poupancaJose = new ContaPoupanca(jose);
        //jose.imprimirDadosDoCliente();
        System.out.println("Jose vai guardar R$1000,00 na poupança!");
        System.out.println();
        contaJose.guardarNaPoupanca(1000,poupancaJose);
        System.out.println();
        System.out.println("E agora, como ficou o extrato de Jose?");
        System.out.println();
        contaJose.imprimirExtrato();
        System.out.println();
        System.out.println("E o extrato da conta poupança de Jose?");
        System.out.println();
        poupancaJose.imprimirExtrato();

        System.out.println("A demonstração acaba aqui! Obrigado!");

    }
}