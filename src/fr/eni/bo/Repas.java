package fr.eni.bo;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Repas {
    private int idRepas;
    private LocalDate dateRepas;
    private LocalTime heureRepas;
    private List<Aliments> aliments;

    public Repas(int idRepas, LocalDate dateRepas, LocalTime heureRepas, List<Aliments> aliments) {
        this.idRepas = idRepas;
        this.dateRepas = dateRepas;
        this.heureRepas = heureRepas;
        this.aliments = aliments;
    }

    public Repas(LocalDate dateRepas, LocalTime heureRepas, List<Aliments> aliments) {
        this.dateRepas = dateRepas;
        this.heureRepas = heureRepas;
        this.aliments = aliments;
    }

    public int getIdRepas() {
        return idRepas;
    }

    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public LocalDate getDateRepas() {
        return dateRepas;
    }

    public void setDateRepas(LocalDate dateRepas) {
        this.dateRepas = dateRepas;
    }

    public LocalTime getHeureRepas() {
        return heureRepas;
    }

    public void setHeureRepas(LocalTime heureRepas) {
        this.heureRepas = heureRepas;
    }

    public List<Aliments> getAliments() {
        return aliments;
    }

    public void setAliments(List<Aliments> aliments) {
        this.aliments = aliments;
    }
}
