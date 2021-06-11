package fr.eni.dal;

import fr.eni.BusinessException;
import fr.eni.bo.Repas;

import java.util.List;

public interface RepasDAO {

    void insert(Repas repas) throws BusinessException;

    List<Repas> selectAll() throws BusinessException;
}
