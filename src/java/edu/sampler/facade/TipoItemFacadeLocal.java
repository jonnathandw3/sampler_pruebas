/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.TipoItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface TipoItemFacadeLocal {

    void create(TipoItem tipoItem);

    void edit(TipoItem tipoItem);

    void remove(TipoItem tipoItem);

    TipoItem find(Object id);

    List<TipoItem> findAll();

    List<TipoItem> findRange(int[] range);

    int count();
    
}
