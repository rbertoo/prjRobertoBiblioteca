package br.edu.utfpr.classes;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Devolucao {
    private Reserva reserva;
    private LocalDate dataEntregada;

    private double valorMulta;

    public Devolucao () {}

    public Devolucao(Reserva reserva, LocalDate dataEntregada) {
        this.reserva = reserva;
        this.dataEntregada = dataEntregada;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public LocalDate getDataEntregada() {
        return dataEntregada;
    }

    public void setDataEntregada(LocalDate dataEntregada) {
        this.dataEntregada = dataEntregada;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public double calcularMulta(Reserva reserva,LocalDate dataEntregada) {
        long diasApos;
        double multa = 0.5;
        diasApos = DAYS.between(reserva.getDataEntrega(),dataEntregada);

        if (diasApos*multa > 20) {
            double novaMulta = 1.0;
            return 20 + ((diasApos - 40) * novaMulta);
        }
        else {
            return  diasApos*multa;
        }
    }
}
