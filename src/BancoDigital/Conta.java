package BancoDigital;

public class Conta implements IConta{
    protected static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

     @Override
    public void sacar(double valor) {
    saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
    saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
    this.sacar(valor);
    contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        Cliente Lucas = new Cliente();
        Lucas.setNome("Lucas");

        Conta cc = new ContaCorrente(Lucas);
        Conta cp = new ContaPoupanca(Lucas);
        cc.depositar(100);
        cp.imprimirExtrato();
        cc.transferir(50, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

    }
}


