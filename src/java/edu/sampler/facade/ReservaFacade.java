/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.Reserva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sebas
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> implements ReservaFacadeLocal {

    @PersistenceContext(unitName = "SamplerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaFacade() {
        super(Reserva.class);
    }
 
    @Override
    public int cantidadReserva(int sala) {
        int cantidad = 0;
        try {
            Query q = em.createNativeQuery("SELECT COUNT(reserva.sala) FROM `reserva` WHERE reserva.sala = ?");
            q.setParameter(1, sala);
            long cantidadL = (long) q.getSingleResult();
            cantidad = (int) cantidadL;
        } catch (Exception e) {
        }
        return cantidad;
    }
}
