package fr.eni.bll;

import fr.eni.bo.Aliments;
import fr.eni.bo.Repas;
import fr.eni.dal.DAOFactory;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RepasManager {
    public static void inserRepas(LocalDate date, LocalTime time, String aliments) {
        String[] tableauAliments = aliments.split(",");
        List<Aliments> listeAliments = new ArrayList<>();

        for (String aliment : tableauAliments){
            aliment = aliment.strip();
            String prmLettre = aliment.substring(0,1).toUpperCase();
            String rstLettre = aliment.substring(1).toLowerCase();
            aliment = prmLettre+rstLettre;
            listeAliments.add(new Aliments(aliment));
        }
        DAOFactory.getRepasDAO().insert(new Repas(date,time,listeAliments));
    }

    public static List<Repas>selectAll(){
        return DAOFactory.getRepasDAO().selectAll();
    }
}
