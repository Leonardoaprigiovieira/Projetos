public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, Cliente cliente, double saldoInicial) {
        super(numero, cliente, saldoInicial);
    }

    public void calcularRendimento(double taxa) {
        if (taxa > 0) {
            saldo += saldo * taxa;
            System.out.println("Rendimento de " + (taxa * 100) + "% aplicado. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Taxa de rendimento inválida.");
        }
    }
}

