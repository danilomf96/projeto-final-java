public class Vilao extends Personagem {

    private int level;
    private String mapa;

    public Vilao() {

    }

    public Vilao(String nome, int ataque, int defesa, int ouro, int level, String mapa) {
        super(nome, ataque, defesa, ouro);
        this.level = level;
        this.mapa = mapa;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLevel=" + level + "\nMapa=" + mapa;
    }

}
