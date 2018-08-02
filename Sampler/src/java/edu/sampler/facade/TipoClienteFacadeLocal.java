/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.TipoCliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface TipoClienteFacadeLocal {

    void create(TipoCliente tipoCliente);

    void edit(TipoCliente tipoCliente);

    void remove(TipoCliente tipoCliente);

    TipoCliente find(Object id);

    List<TipoCliente> findAll();

    List<TipoCliente> findRange(int[] range);

    int count();
    
}
