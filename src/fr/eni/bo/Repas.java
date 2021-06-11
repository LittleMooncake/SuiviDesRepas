package fr.eni.bo;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Repas {
    private int idRepas;
    private Date dateRepas;
    private Time heureRepas;
    private List<Aliments> aliments;

    public Repas(Date dateRepas, Time heureRepas, List<Aliments> aliments) {
        this.dateRepas = dateRepas;
        this.heureRepas = heureRepas;
        this.aliments = aliments;
    }

    public Repas(int idRepas, Date dateRepas, Time heureRepas, List<Aliments> aliments) {
        this.idRepas = idRepas;
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

    public Date getDateRepas() {
        return dateRepas;
    }

    public void setDateRepas(Date dateRepas) {
        this.dateRepas = dateRepas;
    }

    public Time getHeureRepas() {
        return heureRepas;
    }

    public void setHeureRepas(Time heureRepas) {
        this.heureRepas = heureRepas;
    }

    public List<Aliments> getAliments() {
        return aliments;
    }

    public void setAliments(List<Aliments> aliments) {
        this.aliments = aliments;
    }
}
