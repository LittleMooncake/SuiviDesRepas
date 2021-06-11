package fr.eni.dal;

public abstract class CodeErreurDal {

    /**
     * Echec de l'insertion car l'objet est null
     */
    public static final int INSER_OBJET_NULL = 10_000;

    /**
     * Echec lors de l'insertion d'un repas
     */
    public static final int INSERT_REPAS_ECHEC = 10_001;

    /**
     * Echec lors de l'insertion des aliments
     */
    public static final int INSER_ALIMENTS_ECHEC = 10_002;

    /**
     * Echec lors de la récupération des repas
     */
    public static final int SELECT_ALL = 10_003;
}
