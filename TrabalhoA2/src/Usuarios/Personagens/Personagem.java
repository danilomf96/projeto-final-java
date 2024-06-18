package Usuarios.Personagens;

public abstract class Personagem {
    private String nome;
    private int ataque;
    private int defesa;
    private int ouro;
    private int vida;

    public Personagem() {
    }

    public Personagem(String nome, int ataque, int defesa, int ouro, int vida) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.ouro = ouro;
        this.vida = vida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return nome + ";" + ataque + ";" + defesa + ";" + ouro + ";" + vida;
    }

    public void fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length >= 5) {
            this.nome = partes[0];
            this.ataque = Integer.parseInt(partes[1]);
            this.defesa = Integer.parseInt(partes[2]);
            this.ouro = Integer.parseInt(partes[3]);
            this.vida = Integer.parseInt(partes[4]);
        }
    }
}
