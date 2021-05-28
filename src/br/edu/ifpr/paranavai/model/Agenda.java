package br.edu.ifpr.paranavai.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {

    public Agenda() {
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        List<Contato> listaContatos = new ArrayList<>();
        Integer opcao = leitor.nextInt();

        do{
            exibirMenu();

            System.out.print("Opção escolhida: ");


            switch(opcao){
                case 1:

                    System.out.print("Insira o nome do contato");
                    String nome = leitor.next();

                    System.out.print("Insira o email");
                    String email = leitor.next();

                    System.out.print("Insira o telefone");
                    String telefone = leitor.next();

                    listaContatos = inserir(nome, email, telefone);
                    System.out.println("Contato inserido com sucesso!");
                    break;
                case 2:


                    System.out.print("Insira o nome do contato");
                    String nomeBusca = leitor.next();

                    System.out.print("Insira o email");
                    String emailBusca = leitor.next();

                    System.out.print("Insira o telefone");
                    String telefoneBusca = leitor.next();

                    List<Contato> contatosEncontrados = buscarPorNome(listaContatos, nomeBusca, emailBusca, telefoneBusca);

                    if (contatosEncontrados.size() > 0) {
                        System.out.println("Foram encontrados" + contatosEncontrados.size() + "contatos");
                    }
                    break;
                case 3:
                    System.out.print("Insira o nome do contato");
                    String nomeRemove = leitor.next();

                    System.out.print("Insira o email");
                    String emailRemove = leitor.next();

                    System.out.print("Insira o telefone");
                    String telefoneRemove = leitor.next();

                    List<Contato> contatosEncontradosRemover = buscarPorNome(listaContatos, nomeRemove, emailRemove, telefoneRemove);

                    if (contatosEncontradosRemover.size() > 0) {
                        remover(contatosEncontradosRemover.get(0));
                        System.out.println("Contato removido;");
                    }
                    break;
                default:
                    exibirMenu();
            }
        }while(opcao != 99);
    }

    private static void exibirMenu(){
        System.out.println("\n\n");
        System.out.println("+-------------------------------------------+");
        System.out.println("|        Menu de Opções                     |");
        System.out.println("+-------------------------------------------+");
        System.out.println("| 1 - Cadastrar Contato                     |");
        System.out.println("| 2 - Buscar contato                        |");
        System.out.println("| 3 - Remover contato                       |");
        System.out.println("| 99 - Sair                                 |");
        System.out.println("+-------------------------------------------+");
    }

    // inserção de um novo contato na agenda
    public static List<Contato> inserir(String nome, String email, String numero) {
        Contato contatoAdd = new Contato();

        contatoAdd.setNome(nome);
        contatoAdd.setEmail(email);
        contatoAdd.setTelefone(numero);

        List<Contato> listaContatos = new ArrayList<>();

        listaContatos.add(contatoAdd);
        return listaContatos;
    }

    //busca por contatos dentro da agenda com base no nome.
    //Só precisa retornar os contatos cujos nomes correspondem
    //exatamente ao termo buscado
    public static List<Contato> buscarPorNome(List<Contato> listaContatos, String nome, String email, String numero) {

        Matcher matcher = validaEmail(email);
        for (Contato contato : listaContatos) {
            if (contato.getNome() != null && !contato.getNome().isEmpty()){
                listaContatos.contains(contato.getNome().equals(nome));
            } else if (contato.getTelefone() != null && !contato.getTelefone().isEmpty()) {
                listaContatos.contains(contato.getTelefone().equals(numero));
            } else if (contato.getEmail() != null && !contato.getEmail().isEmpty() && matcher.matches()) {
                listaContatos.contains(contato.getEmail().equals(email));
            }
        }


        return listaContatos;
    }

    // remove da agenda o contato passado por parametro
    public static void remover(Contato contato) {

        List<Contato> listaContatos = new ArrayList<>();
        listaContatos.remove(contato);

    }

    public static Matcher validaEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher;
    }


}

