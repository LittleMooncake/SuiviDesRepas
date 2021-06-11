package fr.eni.dal;

import fr.eni.bo.Aliments;
import fr.eni.bo.Repas;

import java.sql.*;

public class RepasDAOimpl implements RepasDAO{
    private final String INSERT_REPAS = "INSERT INTO Repas(date, heure) VALUES (?,?);";
    private final String INSERT_ALIMENT = "INSERT INTO Aliments(idRepas, aliment) VALUES (?,?);";

    @Override
    public void insert(Repas repas) {
        try (Connection connection = JdbcTools.getConnection()){
            PreparedStatement unPrStm = connection.prepareStatement(INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement unPrStm2 = connection.prepareStatement(INSERT_ALIMENT, PreparedStatement.RETURN_GENERATED_KEYS);

            unPrStm.setDate(1, (Date) repas.getDateRepas());
            unPrStm.setTime(2, repas.getHeureRepas());
            unPrStm.executeQuery();
            ResultSet rs = unPrStm.getGeneratedKeys();
            if (rs.next()){
                repas.setIdRepas(rs.getInt(1));
            }

            for (Aliments aliments : repas.getAliments()){
                unPrStm2.setInt(1, repas.getIdRepas());
                unPrStm2.setString(2, aliments.getNom());
                unPrStm2.executeQuery();
                ResultSet rs2 = unPrStm2.getGeneratedKeys();
                if (rs2.next()){
                    aliments.setIdAliments(rs.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
