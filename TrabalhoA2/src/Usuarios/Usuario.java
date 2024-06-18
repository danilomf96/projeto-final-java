package Usuarios;

public class Usuario {

    private String nome;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario() {
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return nome + ";" + senha;
    }

    public void fromString(String linha) {
        String[] partes = linha.split(";");
        if (partes.length == 2) {
            this.nome = partes[0];
            this.senha = partes[1];
        }
    }
}
