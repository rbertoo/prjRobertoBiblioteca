package br.edu.utfpr.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Pessoa pessoa;
    private List<Livro> livros;
    private LocalDate dataReserva;
    private LocalDate dataEntrega;

    public Reserva() {}

    public Reserva (Pessoa pessoa, List<Livro>livros,LocalDate dataReserva, LocalDate dataEntrega) {
        this.pessoa = pessoa;
        this.livros = livros;
        this.dataReserva = dataReserva;
        this.dataEntrega = dataEntrega;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}


