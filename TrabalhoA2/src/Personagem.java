
public class Personagem {

    private String nome;
    private int ptsVida;

    public Personagem() {

    }

    public Personagem(String nome, int ptsVida) {
        this.nome = nome;
        this.ptsVida = ptsVida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPtsVida() {
        return ptsVida;
    }

    public void setPtsVida(int ptsVida) {
        this.ptsVida = ptsVida;
    }

    @Override
    public String toString() {

        return "\nNome: " + nome +
                "\nPontos de vida: " + ptsVida;
    }

}