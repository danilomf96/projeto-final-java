import Usuarios.Usuario;
import Usuarios.UsuarioPersistencia;
import Usuarios.Personagens.Heroi;
import Usuarios.Personagens.PersonagemPersistencia;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class Sistema {

    private static Usuario usuarioLogado = null;

    private static void exibirMenuInicial() {
        System.out.println("\n--Hero of World--");
        System.out.println("1. Novo Jogador");
        System.out.println("2. Fazer Login");
        System.out.println("3. Sair");
    }

    private static void exibirMenuUsuario() {
        System.out.println("\n--Menu de Usuário--");
        System.out.println("1. Criar Herói");
        System.out.println("2. Ver Heróis");
        System.out.println("3. Sair");
    }

    private static void cadastrarUsuario() {
        try {
            System.out.println("\nNome do Usuario:");
            String nome = Console.lerString();
            System.out.println("\nSenha: ");
            String senha = Console.lerString();
            Usuario usuario = new Usuario(nome, senha);

            List<Usuario> listaUsuarios = UsuarioPersistencia.lerDoArquivo();
            listaUsuarios.add(usuario);
            UsuarioPersistencia.salvarNoArquivo(listaUsuarios);

            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private static void fazerLogin() {
        try {
            System.out.println("\nNome do Usuario:");
            String nome = Console.lerString();
            System.out.println("\nSenha: ");
            String senha = Console.lerString();

            if (UsuarioPersistencia.usuarioExiste(nome)) {
                List<Usuario> listaUsuarios = UsuarioPersistencia.lerDoArquivo();
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                        usuarioLogado = usuario;
                        PersonagemPersistencia.criarArquivoSeNaoExistir(nome);
                        System.out.println("Login realizado com sucesso!");
                        return;
                    }
                }
            }
            System.out.println("Nome de usuário ou senha incorretos.");
        } catch (IOException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
    }

    private static void criarHeroi() throws Exception {
        if (usuarioLogado == null) {
            throw new Exception("Você precisa estar logado para criar um herói.");
        }

        try {
            System.out.println("Nome do Herói:");
            String nome = Console.lerString();
            System.out.println("\nEscolha a classe do personagem:\n1. Guerreiro\n2. Mago\n3. Assassino\n");
            int opcaoClasse = Console.lerInt();

            String classe = "";
            int ataque = 0;
            int defesa = 0;
            int ouro = 0;
            int vida = 0;
            int magia = 0;
            int energia = 0;

            switch (opcaoClasse) {
                case 1: // Guerreiro
                    classe = "Guerreiro";
                    ataque = 20;
                    defesa = 15;
                    ouro = 100;
                    vida = 150;
                    break;
                case 2: // Mago
                    classe = "Mago";
                    ataque = 15;
                    defesa = 10;
                    ouro = 150;
                    magia = 50;
                    energia = 50;
                    vida = 120;
                    break;
                case 3: // Assassino
                    classe = "Assassino";
                    ataque = 25;
                    defesa = 10;
                    ouro = 75;
                    vida = 100;
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida. Escolha um número de 1 a 3.");
            }

            Heroi heroi = new Heroi(nome, ataque, defesa, ouro, vida, classe, magia, energia);
            PersonagemPersistencia.salvarHeroi(usuarioLogado.getNome(), heroi);

            System.out.println("Herói criado com sucesso!");
            System.out.println(heroi);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            Console.lerString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}