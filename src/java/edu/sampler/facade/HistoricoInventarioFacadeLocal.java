/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.HistoricoInventario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface HistoricoInventarioFacadeLocal {

    void create(HistoricoInventario historicoInventario);

    void edit(HistoricoInventario historicoInventario);

    void remove(HistoricoInventario historicoInventario);

    HistoricoInventario find(Object id);

    List<HistoricoInventario> findAll();

    List<HistoricoInventario> findRange(int[] range);

    int count();
    
}
