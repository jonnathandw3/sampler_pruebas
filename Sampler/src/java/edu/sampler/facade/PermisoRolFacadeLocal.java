/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.PermisoRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebas
 */
@Local
public interface PermisoRolFacadeLocal {

    void create(PermisoRol permisoRol);

    void edit(PermisoRol permisoRol);

    void remove(PermisoRol permisoRol);

    PermisoRol find(Object id);

    List<PermisoRol> findAll();

    List<PermisoRol> findRange(int[] range);

    int count();
    
}
