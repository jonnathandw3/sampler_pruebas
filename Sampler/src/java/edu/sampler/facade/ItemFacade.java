/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.facade;

import edu.sampler.entity.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sebas
 */
@Stateless
public class ItemFacade extends AbstractFacade<Item> implements ItemFacadeLocal {

    @PersistenceContext(unitName = "SamplerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemFacade() {
        super(Item.class);
    }

    @Override
    public List<Item> cantidadProducto(int nombre_item) {
        List<Item> listaProductos = null;
        try {
            Query q = em.createNativeQuery("SELECT `nombre_item`,`cantidad` FROM `item` WHERE `cantidad` > ?" );
            q.setParameter(1, "1");
            listaProductos = q.getResultList();
        } catch (Exception e) {
        }
        return listaProductos;
    }
}
