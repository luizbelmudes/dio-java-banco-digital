package cliente;

public class Cliente {
    private final String nome;
    private final String sobrenome;
    private double limiteDeCredito;

    public Cliente(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.limiteDeCredito = 1_000.00;
    }

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void imprimirDadosDoCliente(){
        System.out.println("-----------DADOS DO CLIENTE---------");
        System.out.println("NOME CLIENTE: " + nome + " " + sobrenome);
        System.out.printf("LIMITE DE CREDITO: R$%.2f\n", limiteDeCredito);
        System.out.println("----------------FIM-----------------");
    }

}
