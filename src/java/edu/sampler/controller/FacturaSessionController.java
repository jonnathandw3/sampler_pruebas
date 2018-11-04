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
import edu.sampler.facade.HistoricoInventarioFacadeLocal;
import edu.sampler.facade.ItemFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
    @EJB
    HistoricoInventarioFacadeLocal HistoricoInventarioFacadeLocal;

    private Cliente clienteGestion;
    private Banda bandaGestion;
    private Item itemgestion;
    private int total = 0;
    private int subtotal = 0;
    private int iva = 0;
    private int totalpago = 0;

    private Date now = Calendar.getInstance().getTime();

    public FacturaSessionController() {
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

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Item getItemgestion() {
        return itemgestion;
    }

    public void setItemgestion(Item itemgestion) {
        this.itemgestion = itemgestion;
    }

    public List<ItemDetalle> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<ItemDetalle> listaItems) {
        this.listaItems = listaItems;
    }

    public int getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(int totalpago) {
        this.totalpago = totalpago;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public class ItemDetalle {

        private Item item = new Item();
        private int cantidad;
        private double valorUnitario;
        private double subTotal;
        private int idItemCantidad;
        

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public double getValorUnitario() {
            return valorUnitario;
        }

        public void setValorUnitario(double valorUnitario) {
            this.valorUnitario = valorUnitario;
        }

        public double getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(double subTotal) {
            this.subTotal = subTotal;
        }

        public int getIdItemCantidad() {
            return idItemCantidad;
        }

        public void setIdItemCantidad(int idItemCantidad) {
            this.idItemCantidad = idItemCantidad;
        }
    }

    public double suma(List<ItemDetalle> listaItem) {
        subtotal = 0;
        for (ItemDetalle detalle : listaItem) {
            int valor = (int) detalle.subTotal;
            subtotal = subtotal + valor;
        }
        return subtotal;
    }

    public int valorIva() {
        iva = total * 16 / 100;
        return iva;
    }

    public void valorTotal() {
        totalpago = total + iva;
    }

    private List<ItemDetalle> listaItems = new ArrayList<>();

    public void agregarItem(int idItem) {
        Item itemFactura = new Item();
        itemFactura = ItemFacadeLocal.find(idItem);
        ItemDetalle pd = new ItemDetalle();
        pd.setItem(itemFactura);
        pd.setCantidad(1);
        pd.setValorUnitario(itemFactura.getValorUnitario());
        pd.setSubTotal(pd.getValorUnitario() * pd.getCantidad());
        pd.setIdItemCantidad(idItem);
        listaItems.add(pd);
        iva = 0;
        totalpago = 0;
    }
    
    public void editarCantidadItem(int id){
       for (ItemDetalle detalle :listaItems) {
            if (detalle.getItem().getIditem() == id) {
                List<ItemDetalle> listaDetalle = new ArrayList<>();
               //listaDetalle = listaItems.indexOf(id);
                //listaItems.
           } else {
                
           }
        }
        //return subtotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void limpiarItem() {
        total = 0;
        listaItems.clear();
    }

    public List<Item> todosItemActivos() {
        return ItemFacadeLocal.todosItemActivos();
    }

    public List<Banda> todosBanda() {
        return BandaFacadeLocal.findAll();
    }

    public List<Factura> todosFactura() {

        return FacturaFacadeLocal.findAll();
    }

    public List<Item> todosItem() {

        return ItemFacadeLocal.findAll();
    }

    public List<Cliente> todosCliente() {
        return ClienteFacadeLocal.findAll();
    }

}
