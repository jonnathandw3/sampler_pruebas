/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.DemograficoDane;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface DemograficoDaneFacadeLocal {

    void create(DemograficoDane demograficoDane);

    void edit(DemograficoDane demograficoDane);

    void remove(DemograficoDane demograficoDane);

    DemograficoDane find(Object id);

    List<DemograficoDane> findAll();

    List<DemograficoDane> findRange(int[] range);

    int count();
    
}
