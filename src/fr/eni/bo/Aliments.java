package fr.eni.bo;

public class Aliments {
    private String nom;
    private int idRepas;
    private int idAliments;

    public Aliments(String nom, int idRepas, int idAliments) {
        this.nom = nom;
        this.idRepas = idRepas;
        this.idAliments = idAliments;
    }

    public Aliments(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdRepas() {
        return idRepas;
    }

    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public int getIdAliments() {
        return idAliments;
    }

    public void setIdAliments(int idAliments) {
        this.idAliments = idAliments;
    }
}
