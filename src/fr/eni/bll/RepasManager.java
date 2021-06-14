package fr.eni.bll;

import fr.eni.BusinessException;
import fr.eni.bo.Aliments;
import fr.eni.bo.Repas;
import fr.eni.dal.DAOFactory;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RepasManager {
    public static void inserRepas(LocalDate date, LocalTime time, String aliments) throws BusinessException {
        String[] tableauAliments = aliments.split(",");
        List<Aliments> listeAliments = new ArrayList<>();
        BusinessException exception = new BusinessException();

        validerDate(date, exception);
        validerHeure(time, exception);
        if (!aliments.equals("")) {
            for (String aliment : tableauAliments) {
                aliment = aliment.trim();
                String prmLettre = aliment.substring(0, 1).toUpperCase();
                String rstLettre = aliment.substring(1).toLowerCase();
                aliment = prmLettre + rstLettre;
                listeAliments.add(new Aliments(aliment));
            }
        }
        validerAliment(listeAliments, exception);

        if (!exception.hasErreurs()) {
            DAOFactory.getRepasDAO().insert(new Repas(date, time, listeAliments));
        }else {
            throw exception;
        }
    }

    public static List<Repas>selectAll() throws BusinessException {
        return DAOFactory.getRepasDAO().selectAll();
    }

    private static void validerAliment(List<Aliments> listeAliments, BusinessException exception) {
        if (listeAliments.isEmpty()){
            exception.ajouterErreur(CodeErreurBll.LISTE_ALIMENTS_NULL);
        }
    }

    private static void validerHeure(LocalTime time, BusinessException exception) {
        if (time==null){
            exception.ajouterErreur(CodeErreurBll.HEURE_NULL);
        }
    }

    private static void validerDate(LocalDate date, BusinessException exception) {
        if (date == null){
            exception.ajouterErreur(CodeErreurBll.DATE_NULL);
        }
    }
}
