package fr.eni.dal;

public class DAOFactory {

    public static RepasDAO getRepasDAO(){
        return new RepasDAOimpl();
    }
}
