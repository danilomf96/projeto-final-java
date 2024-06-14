public abstract class Personagem {
    private String nome;
    private int ataque;
    private int defesa;
    private int ouro;
    
    
    public Personagem() {
    }

    public Personagem(String nome, int ataque, int defesa, int ouro) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.ouro = ouro;
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

    @Override
    public String toString() {
        return "\nPersonagem Nome=" + nome + "\nAtaque=" + ataque + "\nDefesa=" + defesa + "\nOuro=" + ouro;
    }

    

    
}
