/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.Activo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebas
 */
@Stateless
public class ActivoFacade extends AbstractFacade<Activo> implements ActivoFacadeLocal {

    @PersistenceContext(unitName = "SamplerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivoFacade() {
        super(Activo.class);
    }
    
}
