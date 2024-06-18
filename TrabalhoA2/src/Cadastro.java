import java.util.ArrayList;
import java.util.List;

import Usuarios.Usuario;

public class Cadastro {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void cadastrar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public static List<Usuario> getListaUsuario() {
        return listaUsuarios;
    }

    public static void setListaUsuario(List<Usuario> listaUsuarios) {
        Cadastro.listaUsuarios = listaUsuarios;
    }

    public static Usuario buscar(String nome) {
        for (Usuario temp : listaUsuarios) {
            if (temp.getNome().equals(nome)) {
                return temp;
            }
        }
        return null;
    }

    public static void excluir(Usuario u) {
        listaUsuarios.remove(u);
    }
    
}
