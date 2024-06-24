package Usuarios.Personagens;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemPersistencia {

    public static void salvarHeroi(String nomeUsuario, Heroi heroi) throws IOException {
        String nomeArquivo = nomeUsuario + "_personagem.txt";
        try (FileWriter fWriter = new FileWriter(nomeArquivo, true); // Append mode
                BufferedWriter bWriter = new BufferedWriter(fWriter)) {
            bWriter.write(heroi.toString() + "\n");
        }
    }

    public static List<Heroi> lerHerois(String nomeUsuario) throws IOException {
        String nomeArquivo = nomeUsuario + "_personagem.txt";
        List<Heroi> listaHerois = new ArrayList<>();
        try (FileReader frReader = new FileReader(nomeArquivo);
                BufferedReader bReader = new BufferedReader(frReader)) {
            String linha;
            while ((linha = bReader.readLine()) != null) {
                Heroi heroi = new Heroi();
                heroi.fromString(linha);
                listaHerois.add(heroi);
            }
        }
        return listaHerois;
    }

    public static void criarArquivoSeNaoExistir(String nomeUsuario) {
        try {
            String nomeArquivo = nomeUsuario + "_personagem.txt";
            File arquivo = new File(nomeArquivo);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void atualizarArquivo(String nomeUsuario, List<Heroi> listaHeroisAtualizada) throws IOException {
        String nomeArquivo = nomeUsuario + "_personagem.txt";
        // Sobrescreve o arquivo com a lista de heróis atualizada
        try (FileWriter fWriter = new FileWriter(nomeArquivo);
                BufferedWriter bWriter = new BufferedWriter(fWriter)) {
            for (Heroi heroi : listaHeroisAtualizada) {
                bWriter.write(heroi.toString() + "\n");
            }
        }
    }
    
    public static void atualizarHeroi(String nomeUsuario, Heroi heroiAtualizado) throws Exception {
        List<Heroi> listaHerois = lerHerois(nomeUsuario);
        boolean encontrado = false;
        for (int i = 0; i < listaHerois.size(); i++) {
            Heroi heroi = listaHerois.get(i);
            if (heroi.getNome().equals(heroiAtualizado.getNome())) {
                listaHerois.set(i, heroiAtualizado);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new Exception("Herói com nome " + heroiAtualizado.getNome() + " não encontrado.");
        }
        atualizarArquivo(nomeUsuario, listaHerois);
    }
}
