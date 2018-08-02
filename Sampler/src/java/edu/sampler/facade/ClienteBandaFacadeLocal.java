/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.ClienteBanda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface ClienteBandaFacadeLocal {

    void create(ClienteBanda clienteBanda);

    void edit(ClienteBanda clienteBanda);

    void remove(ClienteBanda clienteBanda);

    ClienteBanda find(Object id);

    List<ClienteBanda> findAll();

    List<ClienteBanda> findRange(int[] range);

    int count();
    
}
