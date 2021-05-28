package br.edu.ifpr.paranavai.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Agenda {

    public Agenda() {
    }

    public static void main(String[] args) {
       String nome = "Carlos Henrique";
       String email = "carlosh@gmail.com";
       String numero = "44998651212";

        // inserir novo contato
        inserir(nome, email, numero);

        //buscar por nome
        List<Contato> contatoBuscado = buscarPorNome(nome);

        remover(contatoBuscado.get(0));
    }
    // inserção de um novo contato na agenda
    public static void inserir(String nome, String email, String numero) {
        Contato contatoAdd = new Contato();

        contatoAdd.setNome(nome);
        contatoAdd.setEmail(email);
        contatoAdd.setTelefone(numero);

        List<Contato> listaContatos = new ArrayList<>();

        listaContatos.add(contatoAdd);

    }

    //busca por contatos dentro da agenda com base no nome.
    //Só precisa retornar os contatos cujos nomes correspondem
    //exatamente ao termo buscado
    public static List<Contato> buscarPorNome(String nome) {
        Contato contatoAdd = new Contato();
        List<Contato> listaContatos = new ArrayList<>();

        String email = "carlosh@gmail.com";
        String numero = "44998651212";

        contatoAdd.setNome(nome);
        contatoAdd.setEmail(email);
        contatoAdd.setTelefone(numero);

        listaContatos.add(contatoAdd);

        listaContatos.contains(contatoAdd.getNome().equals(nome));

        return listaContatos;
    }

    // remove da agenda o contato passado por parametro
    public static void remover(Contato contato) {

        List<Contato> listaContatos = new ArrayList<>();
        listaContatos.remove(contato);

    }
}

