package Usuarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioPersistencia {

    private static final String USUARIOS = "usuarios.txt";

    public static void salvarNoArquivo(List<Usuario> listaUsuarios) throws IOException {
        criarArquivoSeNaoExistir();
        try (FileWriter fWriter = new FileWriter(USUARIOS);
                BufferedWriter bWriter = new BufferedWriter(fWriter)) {
            for (Usuario usuario : listaUsuarios) {
                bWriter.write(usuario.toString() + "\n");
            }
        }
    }

    public static List<Usuario> lerDoArquivo() throws IOException {
        criarArquivoSeNaoExistir();
        List<Usuario> listaUsuarios = new ArrayList<>();
        try (FileReader frReader = new FileReader(USUARIOS);
                BufferedReader bReader = new BufferedReader(frReader)) {
            String linha;
            while ((linha = bReader.readLine()) != null) {
                Usuario usuario = new Usuario();
                usuario.fromString(linha);
                listaUsuarios.add(usuario);
            }
        }
        return listaUsuarios;
    }

    public static void criarArquivoSeNaoExistir() {
        try {
            File arquivo = new File(USUARIOS);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static boolean usuarioExiste(String nome) throws IOException {
        List<Usuario> listaUsuarios = lerDoArquivo();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}
