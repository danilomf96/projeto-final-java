package Usuarios.Personagens;

import EntradaDados.Console;
import Interface.Negociavel;

public class Heroi extends Personagem implements Negociavel{
    private String classe;
    private int magia;
    private int energia;

    public Heroi() {
    }

    public Heroi(String nome, int ataque, int defesa, int ouro, int vida, String classe, int magia, int energia) {
        super(nome, ataque, defesa, ouro, vida);
        this.classe = classe;
        this.magia = magia;
        this.energia = energia;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + classe + ";" + magia + ";" + energia;
    }

    @Override
    public void fromString(String linha) {
        super.fromString(linha);
        String[] partes = linha.split(";");
        if (partes.length == 8) {
            this.classe = partes[5];
            this.magia = Integer.parseInt(partes[6]);
            this.energia = Integer.parseInt(partes[7]);
        }
    }

    @Override
    public void negociar() {
        System.out.println("-- LOJA --");
        System.out.println("1. Comprar poção de vida (50 ouro)");
        System.out.println("2. Comprar poção de magia (30 ouro)");
        System.out.println("3. Comprar poção de energia (30 ouro)");
        System.out.println("4. Sair");

        int escolha = Console.lerInt();
        switch (escolha) {
            case 1:
                if (getOuro() >= 50) {
                    setVida(getVida() + 50);
                    setOuro(getOuro() - 50);
                    System.out.println("Você comprou uma poção de vida!");
                } else {
                    System.out.println("Ouro insuficiente.");
                }
                break;
            case 2:
                if (getOuro() >= 30) {
                    setMagia(getMagia() + 30);
                    setOuro(getOuro() - 30);
                    System.out.println("Você comprou uma poção de magia!");
                } else {
                    System.out.println("Ouro insuficiente.");
                }
                break;
            case 3:
                if (getOuro() >= 30) {
                    setEnergia(getEnergia() + 10);
                    setOuro(getOuro() - 30);
                    System.out.println("Você comprou uma poção de Energia!");
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
