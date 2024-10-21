public class Banco {
    private final Conta[] contas;
    private int quantidadeDeContas;
    private int proximoNumeroConta;

    public Banco() {
        contas = new Conta[5];
        quantidadeDeContas = 0;
        proximoNumeroConta = 1; // Inicializa o número da conta
    }

    public void adicionarConta(Conta conta) {
        if (quantidadeDeContas < 5) {
            contas[quantidadeDeContas] = conta;
            quantidadeDeContas++;
            System.out.println("Conta adicionada com sucesso.");
        } else {
            System.out.println("Limite de contas atingido.");
        }
    }

    public Conta encontrarConta(int numero) {
        for (int i = 0; i < quantidadeDeContas; i++) {
            if (contas[i].getNumero() == numero) {
                return contas[i];
            }
        }
        return null;
    }

    public void listarContas() {
        if (quantidadeDeContas == 0) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (int i = 0; i < quantidadeDeContas; i++) {
                System.out.println(contas[i]);
            }
        }
    }

    // Método para gerar o próximo número de conta
    public int getProximoNumeroConta() {
        return proximoNumeroConta++;
    }
}
