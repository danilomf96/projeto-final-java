package Usuarios.Personagens;

import EntradaDados.Console;
import Interface.Negociavel;

public class Comerciante extends Personagem implements Negociavel{
    int pocaoVida;
    int pocaoAtk;
    int pocaoEnergia;

    public Comerciante(){
    }

    public Comerciante(String nome, int ataque, int defesa, int ouro, int vida, int pocaoVida, int pocaoAtk,
            int pocaoEnergia) {
        super(nome, ataque, defesa, ouro, vida);
        this.pocaoVida = pocaoVida;
        this.pocaoAtk = pocaoAtk;
        this.pocaoEnergia = pocaoEnergia;
    }

    public int getPocaoVida() {
        return pocaoVida;
    }

    public void setPocaoVida(int pocaoVida) {
        this.pocaoVida = pocaoVida;
    }

    public int getPocaoAtk() {
        return pocaoAtk;
    }

    public void setPocaoAtk(int pocaoAtk) {
        this.pocaoAtk = pocaoAtk;
    }

    public int getPocaoEnergia() {
        return pocaoEnergia;
    }

    public void setPocaoEnergia(int pocaoEnergia) {
        this.pocaoEnergia = pocaoEnergia;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void negociar(Heroi heroiUsuario) {
        System.out.println("\n-- LOJA DO COMERCIANTE --");
        System.out.println("1. Comprar Poção de Vida (50 ouro)");
        System.out.println("2. Comprar Poção de Ataque (30 ouro)");
        System.out.println("3. Comprar Poção de Energia (20 ouro)");
        System.out.println("4. Sair");

        int escolha = Console.lerInt();

        switch (escolha) {
            case 1:
                if (heroiUsuario.getOuro() >= 50) {
                    heroiUsuario.setVida(heroiUsuario.getVida() + 50);
                    heroiUsuario.setOuro(heroiUsuario.getOuro() - 50);
                    System.out.println("Você comprou uma poção de vida!");
                } else {
                    System.out.println("Ouro insuficiente.");
                }
                break;
            case 2:
                if (heroiUsuario.getOuro() >= 30) {
                    heroiUsuario.setAtaque(heroiUsuario.getAtaque() + 10);
                    heroiUsuario.setOuro(heroiUsuario.getOuro() - 30);
                    System.out.println("Você comprou uma poção de ataque!");
                } else {
                    System.out.println("Ouro insuficiente.");
                }
                break;
            case 3:
                if (heroiUsuario.getOuro() >= 20) {
                    heroiUsuario.setEnergia(heroiUsuario.getEnergia() + 20);
                    heroiUsuario.setOuro(heroiUsuario.getOuro() - 20);
                    System.out.println("Você comprou uma poção de energia!");
                } else {
                    System.out.println("Ouro insuficiente.");
                }
                break;
            case 4:
                System.out.println("Saindo da loja...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }
}
