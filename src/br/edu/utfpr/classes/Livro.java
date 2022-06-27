package br.edu.utfpr.classes;

public class Livro {

    private String nomeLivro;
    private int numeroPaginas;

    private boolean livroDisponivel;
    private int idLivro;

    public Livro() {}

    public Livro (int idLivro, String nomeLivro, int numeroPaginas, boolean livroDisponivel) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.numeroPaginas = numeroPaginas;
        this.livroDisponivel = livroDisponivel;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean getLivroDisponivel() {
        return livroDisponivel;
    }

    public void setLivroDisponivel(boolean livroDisponivel) {
        this.livroDisponivel = livroDisponivel;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
}