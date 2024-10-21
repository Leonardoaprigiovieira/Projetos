public class ContaCorrente extends Conta {

    private final double limite;

    public ContaCorrente(int numero, Cliente cliente, double saldoInicial, double limite) {
        super(numero, cliente, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (saldo + limite) >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado na conta corrente " + numero);
            return true;
        } else {
            System.out.println("Saldo e limite insuficientes para saque.");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Limite: R$" + limite;
    }
}