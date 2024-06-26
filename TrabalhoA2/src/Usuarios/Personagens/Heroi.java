package Usuarios.Personagens;


import Interface.Negociavel;

public class Heroi extends Personagem implements Negociavel {
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
    public void negociar(Heroi heroiUsuario) {
        System.out.println("\n-- LOJA --");
        System.out.println("Voce possui " + heroiUsuario.getOuro() + " de ouro");
    }
}
