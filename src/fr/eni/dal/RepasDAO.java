package fr.eni.dal;

import fr.eni.bo.Repas;

import java.util.List;

public interface RepasDAO {

    void insert(Repas repas);

    List<Repas> selectAll();
}
