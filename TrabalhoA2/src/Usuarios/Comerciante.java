package Usuarios;

import Usuarios.Personagens.Personagem;

public class Comerciante extends Personagem {
    int pocaoVida;
    int pocaoAtk;
    int pocaoEnergia;

    public Comerciante() {
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

}
