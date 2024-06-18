package Usuarios.Personagens;

public class Vendedor extends Personagem{

@Override
public void setAtaque(int ataque) {
    ataque = 0;
    super.setAtaque(ataque);
}  

@Override
public void setDefesa(int defesa) {
    defesa = 0;
    super.setDefesa(defesa);
}
@Override
public void setOuro(int ouro) {
    ouro = 0;
    super.setOuro(ouro);
}
@Override
public void setVida(int vida) {
    vida = 0;
    super.setVida(vida);
}

public static String[] gerarArma() {
    String[] tiposArmas = {"espada", "machado", "pedra", "arco"};
    String[] elementos = {"de fogo", "de gelo", "de vento"};

    return combinarTiposEElementos(tiposArmas, elementos);
}
public static String[] gerarArmadura() {
    String[] tiposArmaduras = {"capacete", "peitoral", "perneira", "bota","escudo"};
    String[] elementos = {"de fogo", "de gelo", "de vento"};

    return combinarTiposEElementos(tiposArmaduras, elementos);
}

public static String[] combinarTiposEElementos(String[] tipos, String[] elementos) {
    int totalCombinacoes = tipos.length * elementos.length;
    String[] resultado = new String[totalCombinacoes];

    int index = 0;
    for (String tipo : tipos) {
        for (String elemento : elementos) {
            resultado[index++] = tipo + " " + elemento;
        }
    }
    return resultado;
}

}