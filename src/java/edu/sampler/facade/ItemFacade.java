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
    public List<Item> todosItemActivos() {
        List<Item> itemLista = null;
        try {
            Query q = em.createNativeQuery("SELECT * FROM `item` WHERE estado_servicio ='1'", Item.class);
            itemLista = q.getResultList();

        } catch (Exception e) {
        }
        return itemLista;
    }

    
    @Override
    public List<Item> todosProductos() {
        List<Item> itemLista = null;
        try {
            Query q = em.createNativeQuery("SELECT * FROM `item` WHERE id_tipo_item ='1'", Item.class);
            itemLista = q.getResultList();

        } catch (Exception e) {
        }
        return itemLista;
    }
    
    @Override
    public List<Item> todosServicios() {
        List<Item> itemLista = null;
        try {
            Query q = em.createNativeQuery("SELECT * FROM `item` WHERE id_tipo_item ='2'", Item.class);
            itemLista = q.getResultList();
        } catch (Exception e) {
        }
        return itemLista;
    }
    
    @Override
    public int cantidadProducto(int sala) {
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
