/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.Banda;
import edu.sampler.entity.Cliente;
import edu.sampler.entity.Factura;
import edu.sampler.entity.Item;
import edu.sampler.facade.BandaFacadeLocal;
import edu.sampler.facade.ClienteFacadeLocal;
import edu.sampler.facade.FacturaFacadeLocal;
import edu.sampler.facade.ItemFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sebas
 */
@Named(value = "facturaSessionController")
@SessionScoped
public class FacturaSessionController implements Serializable {

    /**
     * Creates a new instance of FacturaSessionController
     */
    
    @EJB
    FacturaFacadeLocal FacturaFacadeLocal;
    @EJB
    ItemFacadeLocal ItemFacadeLocal;
    @EJB
    ClienteFacadeLocal ClienteFacadeLocal;
    @EJB
    BandaFacadeLocal BandaFacadeLocal; 
    
    private Cliente clienteGestion;
    private Banda bandaGestion;
    
    private java.util.Date dates = new java.util.Date();
                private long fechaSis = dates.getTime();
                private Date now = new Date(fechaSis);
    
    public FacturaSessionController() {
    }
    
    public List<Banda> todosBanda(){
    return BandaFacadeLocal.findAll();
    }
    
    public List<Factura> todosFactura(){
        
    return FacturaFacadeLocal.findAll();
    }
    
    public List<Item> todosItem(){
        
    return ItemFacadeLocal.findAll();
    }
    
    public List<Cliente> todosCliente(){
    return ClienteFacadeLocal.findAll();
    }

    public java.util.Date getDates() {
        return dates;
    }

    public void setDates(java.util.Date dates) {
        this.dates = dates;
    }

    public long getFechaSis() {
        return fechaSis;
    }

    public void setFechaSis(long fechaSis) {
        this.fechaSis = fechaSis;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Cliente getClienteGestion() {
        return clienteGestion;
    }

    public void setClienteGestion(Cliente clienteGestion) {
        this.clienteGestion = clienteGestion;
    }

    public Banda getBandaGestion() {
        return bandaGestion;
    }

    public void setBandaGestion(Banda bandaGestion) {
        this.bandaGestion = bandaGestion;
    }
    
    
    
}
