package Usuarios.Personagens;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemPersistencia {

    private static ArrayList<Heroi> listaHerois = new ArrayList<>();

    public static ArrayList<Heroi> getListaHerois() throws Exception {

        verirficarListaVazia();
        return listaHerois;
    }

    private static void verirficarListaVazia() throws Exception {
        if (listaHerois.isEmpty()) {
            throw new Exception("\nATENÇÃO: Não há Herois cadastrados");
        }
    }

    public static void salvarHeroi(String nomeUsuario, Heroi heroi) throws IOException {
        String nomeArquivo = nomeUsuario + "_personagem.txt";
        try (FileWriter fWriter = new FileWriter(nomeArquivo, true); // Append mode
                BufferedWriter bWriter = new BufferedWriter(fWriter)) {
            bWriter.write(heroi.toString() + "\n");
        }
    }

    
    public static List<Heroi> lerHerois(String nomeUsuario) throws IOException {
        String nomeArquivo = nomeUsuario + "_personagem.txt";
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
        verirficarListaVazia();
        lerHerois(nomeUsuario);
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

    public static Heroi buscarHeroi(String nome) throws Exception {

        verirficarListaVazia();

        for (Heroi tempHeroi : listaHerois) {

            if (tempHeroi.getNome().equals(nome)) {

                return tempHeroi;
            }
        }

        throw new Exception("\nHerói com o nome " + nome + " não localizado");

    }
    public static void apagarHeroi(String nome) throws Exception {
        verirficarListaVazia();

        boolean encontrou = false;

        for (Heroi tempHeroi : listaHerois) {

            if (tempHeroi.getNome().equals(nome)) {

                encontrou = true;
                listaHerois.remove(tempHeroi);
                atualizarHeroi(nome, tempHeroi);
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nHeroi " + nome + " não foi encontrado");
        }
    }
}
