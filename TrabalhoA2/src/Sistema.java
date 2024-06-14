public class Sistema {

    private static void exibirMenu() {
        System.out.println("\n--Hero of World--");
        System.out.println("Fazer Login");
        System.out.println("Novo Jogador");
    }

    private static void cadastrarUsuario() {
        System.out.println("\nNome do Usuario:");
        String novoArquivo = Console.lerString();
    }

    private static void fazerLogin() {
        System.out.println("\nNome do Usuario:");
        String nomeArquivo = Console.lerString();
    }

    private static void criarHeroi() {

        String nome;
        System.out.println("Nome:");
        nome = Console.lerString();
        System.out.println("\nEscolha a classe do personagem:\n1. Guerreiro\n2. Mago\n3. Assassino\n");
        int opcaoClasse = Console.lerInt();

        String classe = "";
        switch (opcaoClasse) {
            case 1:
                System.out.println("Você escolheu: Guerreiro");
                classe = "Guerreiro";
                break;
            case 2:
                System.out.println("Você escolheu: Mago");
                classe = "Mago";
                break;
            case 3:
                System.out.println("Você escolheu: Assassino");
                classe = "Assassino";
                break;
            default:
                System.out.println("Opção inválida. Escolha um número de 1 a 3.");
                criarHeroi();
                return;
        }
    }
}