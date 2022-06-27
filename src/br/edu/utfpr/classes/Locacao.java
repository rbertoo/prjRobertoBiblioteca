package br.edu.utfpr.classes;

public class Locacao {
    private Livro livro;

    public Locacao () {}
    public Locacao (Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro () {
        return livro;
    }

    public boolean verificarLivro (Livro livro) {
        if(livro.getLivroDisponivel()) {
            System.out.println("Livro disponivel");
            return true;
        }
        else {
            System.out.println("Livro indisponivel");
            return false;
        }

    }
}
