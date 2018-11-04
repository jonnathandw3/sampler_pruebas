/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.Banda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface BandaFacadeLocal {

    void create(Banda banda);

    void edit(Banda banda);

    void remove(Banda banda);

    Banda find(Object id);

    List<Banda> findAll();

    List<Banda> findRange(int[] range);

    int count();
    
}
