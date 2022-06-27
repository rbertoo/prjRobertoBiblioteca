package br.edu.utfpr.main;

import br.edu.utfpr.classes.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String []args) {
        final Pessoa[] pessoa = new Pessoa[1];
        final Reserva[] reserva = new Reserva[1];
        Scanner scan = new Scanner(System.in);
        int escolha;
        List<Livro> livrosBiblioteca = new ArrayList<>();
        livrosBiblioteca.add(new Livro(1, "O Senhor dos Anéis: A Sociedade do Anel", 450, true));
        livrosBiblioteca.add(new Livro(2, "Harry Potter e a Pedra Filosofal", 264, true));
        livrosBiblioteca.add(new Livro(3, "It: A coisa", 1104, true));

        System.out.println("Livros da biblioteca");
        livrosBiblioteca.forEach(livro -> System.out.println(livro.getIdLivro() +"-"+ livro.getNomeLivro()));

        do {

            System.out.println("\nEscolha: \n1-Reservar \n2-Devolver \n3-Sair");
            escolha = scan.nextInt();
            switch (escolha){
                case 1:
                    final Locacao[] locacao = new Locacao[1];
                    System.out.println("Digite o id do Livro");
                    int idLivro = scan.nextInt();
                    List<Livro> livroEscolhido = livrosBiblioteca.stream()
                            .filter(livro -> livro.getIdLivro() == idLivro)
                            .toList();
                    livroEscolhido.forEach(livro -> {
                        locacao[0] = new Locacao();
                        if(locacao[0].verificarLivro(livro)) {
                            System.out.println("Escreva seu nome");
                            String nome = scan.next();
                            pessoa[0] = new Pessoa(nome);
                            LocalDate dataEntrega = ChronoUnit.DAYS.addTo(LocalDate.now(), 7);
                            reserva[0] = new Reserva(pessoa[0], livroEscolhido,LocalDate.now(), dataEntrega);
                            System.out.println("Reserva feita para "+ pessoa[0].getNomePessoa()+". \n" +
                                    "Entregar o livro na data "+dataEntrega);
                        }
                        livro.setLivroDisponivel(false);
                    });

                    break;

                case 2:
                    Devolucao devolucao;
                    System.out.println("Informe seu nome");
                    String nome = scan.next();
                    if (nome.equals(pessoa[0].getNomePessoa())) {
                        System.out.println("Voce tem livro(s) a devolver.\nInforme a data devolvida [aaaa-mm-dd]:");
                        String dataDevolucao = scan.next();
                        LocalDate data = LocalDate.parse(dataDevolucao);
                        //System.out.println(data);
                        devolucao = new Devolucao();
                        if (data.isAfter(reserva[0].getDataEntrega())){
                            double multa = devolucao.calcularMulta(reserva[0],data);
                            System.out.println("Voce tem multa a pagar!\nvalor R$"+multa);
                            livrosBiblioteca.stream()
                                    .filter(livro -> livro == reserva[0].getLivros())
                                    .forEach(livro -> livro.setLivroDisponivel(true));
                        }else {
                            System.out.println("Livro entregue dentro do prazo.");
                            livrosBiblioteca.stream()
                                    .filter(livro -> livro == reserva[0].getLivros())
                                    .forEach(livro -> livro.setLivroDisponivel(true));
                        }
                    } else{
                        System.out.println("Nao foram encontradas pendencias.");
                    }
                    break;

                default:
                    System.out.println("Fim sistema biblioteca.");
            }

        }while (escolha != 3);
    }

}

