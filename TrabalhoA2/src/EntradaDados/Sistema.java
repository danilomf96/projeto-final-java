package EntradaDados;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

import Usuarios.Usuario;
import Usuarios.UsuarioPersistencia;
import Usuarios.Personagens.Heroi;
import Usuarios.Personagens.Personagem;
import Usuarios.Personagens.PersonagemPersistencia;
import Usuarios.Personagens.Vilao;


public class Sistema{

    private static Usuario usuarioLogado = null;
    private static Heroi heroiUsuario = null;
    private static Vilao vilaoInimigo = null;

    private static final Vilao DRACO = new Vilao("Draco, o Dragão do Inferno", 30, 20, 200, 300, 10, "Montanhas de Fogo");
    private static final Vilao MORGANA = new Vilao("Morgana, a Feiticeira Sombria", 25, 15, 150, 250, 8, "Floresta das Sombras");
    private static final Vilao KRAKEN = new Vilao("Kraken, o Monstro dos Mares", 35, 25, 100, 350, 12, "Abismo do Oceano");
    private static final Vilao LOKI = new Vilao("Loki, o Enganador", 20, 10, 300, 200, 7, "Palácio das Ilusões");
    private static final Vilao FENRIR = new Vilao("Fenrir, o Lobo Gigante", 40, 30, 250, 400, 15, "Planícies Congeladas");

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
        System.out.println("3. Iniciar batalha");
        System.out.println("4. Sair");
    }

    private static void menuBatalha() {
        System.out.println("--BATALHA--");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar Magia");
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
                    energia = 50;
                    vida = 150;
                    break;
                case 2: // Mago
                    classe = "Mago";
                    ataque = 15;
                    defesa = 10;
                    ouro = 150;
                    energia = 50;
                    vida = 120;
                    magia = 30; // Adicionando valor de magia para Mago
                    break;
                case 3: // Assassino
                    classe = "Assassino";
                    ataque = 25;
                    defesa = 10;
                    ouro = 75;
                    energia = 50;
                    vida = 100;
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida. Escolha um número de 1 a 3.");
            }

            heroiUsuario = new Heroi(nome, ataque, defesa, ouro, vida, classe, magia, energia);
            PersonagemPersistencia.salvarHeroi(usuarioLogado.getNome(), heroiUsuario);

            System.out.println("Herói criado com sucesso!");
            System.out.println(heroiUsuario);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            Console.lerString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibirHerois() {
        try {
            List<Heroi> herois = PersonagemPersistencia.lerHerois(usuarioLogado.getNome());
            if (herois.isEmpty()) {
                System.out.println("Nenhum herói encontrado.");
            } else {
                for (Heroi heroi : herois) {
                    System.out.println(heroi);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler heróis: " + e.getMessage());
        }
    }

    private static void selecionarVilao() {
        int escolha = (int) (Math.random() * 5);
        switch (escolha) {
            case 0:
                vilaoInimigo = DRACO;
                break;
            case 1:
                vilaoInimigo = MORGANA;
                break;
            case 2:
                vilaoInimigo = KRAKEN;
                break;
            case 3:
                vilaoInimigo = LOKI;
                break;
            case 4:
                vilaoInimigo = FENRIR;
                break;
        }
    }

    public static void batalha() {
    try {
        if (heroiUsuario == null) {
            throw new Exception("Você precisa criar um herói antes de iniciar uma batalha.");
        }

        selecionarVilao();
        System.out.println("Batalha iniciada entre " + heroiUsuario.getNome() + " e " + vilaoInimigo.getNome());

        int vidaOriginalVilao = vilaoInimigo.getVida();

        while (heroiUsuario.getVida() > 0 && vilaoInimigo.getVida() > 0) {
            menuBatalha();
            int escolha = Console.lerInt();
            switch (escolha) {
                case 1:
                    atacar(heroiUsuario, vilaoInimigo);
                    break;
                case 2:
                    defender(heroiUsuario);
                    break;
                case 3:
                    usarMagia(heroiUsuario, vilaoInimigo);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            if (vilaoInimigo.getVida() > 0) { 
                atacar(vilaoInimigo, heroiUsuario);
            }

            System.out.println("Status do Herói: " + heroiUsuario);
            System.out.println("Status do Vilão: " + vilaoInimigo);
        }

        if (heroiUsuario.getVida() > 0) {
            System.out.println("Parabéns! Você derrotou " + vilaoInimigo.getNome());
        } else {
            System.out.println("Você foi derrotado por " + vilaoInimigo.getNome());
        }

        // Resetando a vida do vilão para futuras batalhas
        vilaoInimigo.setVida(vidaOriginalVilao);

    } catch (Exception e) {
        System.out.println("Erro na batalha: " + e.getMessage());
    }
}


    private static void atacar(Personagem atacante, Personagem defensor) {
        int dano = atacante.getAtaque() - defensor.getDefesa();
        if (dano > 0) {
            defensor.setVida(defensor.getVida() - dano);
            System.out.println(atacante.getNome() + " causou " + dano + " de dano a " + defensor.getNome());
        } else {
            System.out.println(atacante.getNome() + " não conseguiu causar dano a " + defensor.getNome());
        }
    }

    private static void defender(Heroi heroi) {
        heroi.setDefesa(heroi.getDefesa() + 10);
        System.out.println(heroi.getNome() + " está defendendo e aumentou sua defesa temporariamente!");
    }

    private static void usarMagia(Heroi heroi, Personagem vilao) {
        if (heroi.getMagia() > 0) {
            int danoMagia = heroi.getMagia() * 2;
            vilao.setVida(vilao.getVida() - danoMagia);
            heroi.setMagia(heroi.getMagia() - 10);
            System.out.println(heroi.getNome() + " usou magia e causou " + danoMagia + " de dano a " + vilao.getNome());
        } else {
            System.out.println(heroi.getNome() + " não tem magia suficiente para usar.");
        }
    }

    public static void executar() {
        while (true) {
            exibirMenuInicial();
            int opcao = Console.lerInt();
            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    fazerLogin();
                    exibirMenuUsuario();
                    int opcaoUsuario = Console.lerInt();
                    switch (opcaoUsuario) {
                        case 1:
                            try {
                                criarHeroi();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            exibirHerois();
                            break;
                        case 3:
                            batalha();
                            break;
                        case 4:
                            System.out.println("Saindo...");
                            return;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}