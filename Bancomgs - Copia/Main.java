import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
            do {
                System.out.println("\n=== Sistema de Gerenciamento de Contas Bancárias ===");
                System.out.println("1. Adicionar Cliente e Criar Conta");
                System.out.println("2. Realizar Saque");
                System.out.println("3. Realizar Depósito");
                System.out.println("4. Realizar Transferência");
                System.out.println("5. Listar Contas");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        adicionarCliente(banco, scanner);
                        break;
                    case 2:
                        realizarSaque(banco, scanner);
                        break;
                    case 3:
                        realizarDeposito(banco, scanner);
                        break;
                    case 4:
                        realizarTransferencia(banco, scanner);
                        break;
                    case 5:
                        banco.listarContas();
                        break;
                    case 6:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 6);
        }
    }

    // Método para adicionar um cliente e criar uma conta
    private static void adicionarCliente(Banco banco, Scanner scanner) {
        System.out.println("\n=== Adicionar Cliente e Criar Conta ===");
        System.out.print("Nome do cliente: ");
        String nome = scanner.next();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.next();

        Cliente cliente = new Cliente(nome, cpf);

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        Conta conta;
        if (tipoConta == 1) {
            System.out.print("Digite o limite da Conta Corrente: ");
            double limite = scanner.nextDouble();
            conta = new ContaCorrente(banco.getProximoNumeroConta(), cliente, saldoInicial, limite);
        } else {
            conta = new ContaPoupanca(banco.getProximoNumeroConta(), cliente, saldoInicial);
        }

        banco.adicionarConta(conta);
        System.out.println("Conta criada com sucesso!");
    }

    // Método para realizar um saque
    private static void realizarSaque(Banco banco, Scanner scanner) {
        System.out.println("\n=== Realizar Saque ===");
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = banco.encontrarConta(numeroConta);

        if (conta != null) {
            System.out.print("Digite o valor do saque: ");
            double valor = scanner.nextDouble();
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Método para realizar um depósito
    private static void realizarDeposito(Banco banco, Scanner scanner) {
        System.out.println("\n=== Realizar Depósito ===");
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = banco.encontrarConta(numeroConta);

        if (conta != null) {
            System.out.print("Digite o valor do depósito: ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    // Método para realizar uma transferência
    private static void realizarTransferencia(Banco banco, Scanner scanner) {
        System.out.println("\n=== Realizar Transferência ===");
        System.out.print("Número da conta de origem: ");
        int numeroContaOrigem = scanner.nextInt();
        Conta contaOrigem = banco.encontrarConta(numeroContaOrigem);

        if (contaOrigem != null) {
            System.out.print("Número da conta de destino: ");
            int numeroContaDestino = scanner.nextInt();
            Conta contaDestino = banco.encontrarConta(numeroContaDestino);

            if (contaDestino != null) {
                System.out.print("Digite o valor da transferência: ");
                double valor = scanner.nextDouble();
                contaOrigem.transferir(contaDestino, valor);
            } else {
                System.out.println("Conta de destino não encontrada.");
            }
        } else {
            System.out.println("Conta de origem não encontrada.");
        }
    }
}
