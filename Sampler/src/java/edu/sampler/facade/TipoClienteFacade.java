/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.TipoCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebas
 */
@Stateless
public class TipoClienteFacade extends AbstractFacade<TipoCliente> implements TipoClienteFacadeLocal {

    @PersistenceContext(unitName = "SamplerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoClienteFacade() {
        super(TipoCliente.class);
    }
    
}
