/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.Autenticado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface AutenticadoFacadeLocal {

    void create(Autenticado autenticado);

    void edit(Autenticado autenticado);

    void remove(Autenticado autenticado);

    Autenticado find(Object id);

    List<Autenticado> findAll();

    List<Autenticado> findRange(int[] range);

    int count();
    
}
