public class Heroi extends Personagem {
    private String classe;
    private int magia;
    private int energia;

    public Heroi() {

    }

    public Heroi(String nome, int ataque, int defesa, int ouro, String classe, int magia, int energia) {
        super(nome, ataque, defesa, ouro);
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
        return super.toString() + "\nHeroi classe=" + classe + "\nMagia=" + magia + "\nEnergia=" + energia;
    }

}
