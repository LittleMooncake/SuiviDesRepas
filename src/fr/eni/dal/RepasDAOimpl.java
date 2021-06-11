package fr.eni.dal;

import fr.eni.BusinessException;
import fr.eni.bo.Aliments;
import fr.eni.bo.Repas;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepasDAOimpl implements RepasDAO{
    private final String SELECT_ALL = "SELECT * FROM Repas LEFT JOIN Aliments ON Repas.idRepas = Aliments.idRepas ORDER BY Repas.date DESC, Repas.heure DESC;";
    private final String INSERT_REPAS = "INSERT INTO Repas(date, heure) VALUES (?,?);";
    private final String INSERT_ALIMENT = "INSERT INTO Aliments(idRepas, aliment) VALUES (?,?);";

    @Override
    public void insert(Repas repas) throws BusinessException {
        if (repas==null){
            BusinessException e = new BusinessException();
            e.ajouterErreur(CodeErreurDal.INSER_OBJET_NULL);
            throw e;
        }
        try (Connection connection = JdbcTools.getConnection()){
            connection.setAutoCommit(false);
            PreparedStatement unPrStm = connection.prepareStatement(INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement unPrStm2 = connection.prepareStatement(INSERT_ALIMENT, PreparedStatement.RETURN_GENERATED_KEYS);

            try {
                unPrStm.setDate(1, Date.valueOf(repas.getDateRepas()));
                unPrStm.setTime(2, Time.valueOf(repas.getHeureRepas()));
                unPrStm.executeUpdate();
                ResultSet rs = unPrStm.getGeneratedKeys();
                if (rs.next()) {
                    repas.setIdRepas(rs.getInt(1));
                }
            }catch (SQLException e) {
                BusinessException businessException = new BusinessException();
                businessException.ajouterErreur(CodeErreurDal.INSERT_REPAS_ECHEC);
                throw businessException;
            }
            try {

                for (Aliments aliments : repas.getAliments()){
                    aliments.setIdRepas(repas.getIdRepas());
                    unPrStm2.setInt(1, aliments.getIdRepas());
                    unPrStm2.setString(2, aliments.getNom());
                    unPrStm2.executeUpdate();
                    ResultSet rs2 = unPrStm2.getGeneratedKeys();
                    if (rs2.next()){
                        aliments.setIdAliments(rs2.getInt(1));
                    }
                }
                connection.commit();
            } catch (SQLException e){
                connection.rollback();
                BusinessException businessException = new BusinessException();
                businessException.ajouterErreur(CodeErreurDal.INSER_ALIMENTS_ECHEC);
                throw businessException;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Repas> selectAll() throws BusinessException {
        List<Repas> listeRepas = new ArrayList<>();
        try (Connection connection = JdbcTools.getConnection()){
            PreparedStatement unPrStm = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = unPrStm.executeQuery();
            while (rs.next()){
                List<Aliments> listeAliments = new ArrayList<>();
                if (listeRepas.isEmpty() || listeRepas.get(listeRepas.size()-1).getIdRepas()!=rs.getInt(1)){
                    listeAliments.add(new Aliments(rs.getString("aliment"), rs.getInt("idRepas"), rs.getInt("idAliment")));
                    listeRepas.add(new Repas(rs.getInt("idRepas"),
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("heure").toLocalTime(),
                            listeAliments));
                } else if (listeRepas.get(listeRepas.size()-1).getIdRepas()==rs.getInt(1)){
                    listeAliments = listeRepas.get(listeRepas.size()-1).getAliments();
                    listeAliments.add(new Aliments(rs.getString("aliment"), rs.getInt("idRepas"), rs.getInt("idAliment")));
                    listeRepas.get(listeRepas.size()-1).setAliments(listeAliments);
                }
            }
        } catch (SQLException throwables) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodeErreurDal.SELECT_ALL);
            throw businessException;
        }

        return listeRepas;
    }
}
