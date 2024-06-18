package Usuarios.Personagens;

public class Vilao extends Personagem {

    private int level;
    private String mapa;

    public Vilao() {
    }

    public Vilao(String nome, int ataque, int defesa, int ouro, int vida, int level, String mapa) {
        super(nome, ataque, defesa, ouro, vida);
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

    @Override
    public void fromString(String linha) {
        super.fromString(linha);
        String[] partes = linha.split(";");
        if (partes.length >= 6) {
            this.level = Integer.parseInt(partes[4]);
            this.mapa = partes[5];
        }
    }
}
