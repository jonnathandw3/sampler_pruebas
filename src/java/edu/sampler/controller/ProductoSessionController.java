/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.HistoricoInventario;
import edu.sampler.entity.Item;
import edu.sampler.entity.Sede;
import edu.sampler.facade.HistoricoInventarioFacadeLocal;
import edu.sampler.facade.ItemFacadeLocal;
import edu.sampler.facade.SedeFacadeLocal;
import edu.sampler.facade.TipoItemFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author sebas
 */
@Named(value = "productoSessionController")
@SessionScoped
public class ProductoSessionController implements Serializable {

    @EJB
    private ItemFacadeLocal itemFacadeLocal;
    @EJB
    private TipoItemFacadeLocal tipoItemFacadeLocal;
    @EJB
    private SedeFacadeLocal sedeFacadeLocal;
    @EJB
    private HistoricoInventarioFacadeLocal historicoInventarioFacadeLocal;

    private Item itemGestion;
    private Item itemEliminar;
    private int idTipoItem = 1;
    private String nombreItem;
    private String descripcion;
    private double valorUnitario;
    private String fechaInicio;
    private String estadoServicio;
    //Historico
    private HistoricoInventario historicoGestion;
    private int idhistoricoInventario;
    private int idSede;
    private int idactivoproducto;
    private int cantidad;
    private String estadohistorico_inventario;
    private Date fechahistorico_inventario;
    private String tipo;

    /**
     * Creates a new instance of ProductoSessionController
     */
    public ProductoSessionController() {
    }

   public String actualizarItem() {
        itemFacadeLocal.edit(itemGestion);
        actualizarItemHistorico();
        return null;
    }
    public String actualizarItemHistorico() {
        historicoInventarioFacadeLocal.edit(historicoGestion);
        return null;
    }

    public String eliminarItem(Item itemEliminar) {
        itemFacadeLocal.remove(itemEliminar);
        return "";
    }

    public List<Item> todosProductos() {
        return itemFacadeLocal.todosProductos();
    }

    public List<Sede> listaSedes() {
        return sedeFacadeLocal.findAll();
    }

    public String ingresarNuevoProducto() {

        java.util.Date fecha = new Date();
        Item itemNuevo = new Item();

        itemNuevo.setIdTipoItem(tipoItemFacadeLocal.find(this.idTipoItem));
        itemNuevo.setNombreItem(nombreItem);
        itemNuevo.setDescripcion(descripcion);
        itemNuevo.setValorUnitario(valorUnitario);
        itemNuevo.setFechaInicio(fecha);
        itemFacadeLocal.create(itemNuevo);
        ingresarProductoHistorico();

        this.nombreItem = "";
        this.descripcion = "";
        this.valorUnitario = 0;

        FacesMessage infoMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item", "Registrado exitosamente");
        FacesContext.getCurrentInstance().addMessage("miItem", infoMensaje);

        return null;
    }

    public String ingresarProductoHistorico() {

        java.util.Date fecha = new Date();
        HistoricoInventario itemHistorico = new HistoricoInventario();

        double numeroAleatori = Math.random() * 10000;
        int CodigoHistoricoInt = (int) numeroAleatori;
        String idhistorico = "" + CodigoHistoricoInt;

        itemHistorico.setIdSede(sedeFacadeLocal.find(this.idSede));
        itemHistorico.setIdactivoproducto(Integer.parseInt(idhistorico));
        itemHistorico.setCantidad(cantidad);
        itemHistorico.setEstadohistoricoInventario(estadohistorico_inventario);
        itemHistorico.setFechahistoricoInventario(fecha);
        itemHistorico.setTipo("producto");

        historicoInventarioFacadeLocal.create(itemHistorico);
        this.idSede = 0;
        this.cantidad = 0;
        this.estadohistorico_inventario = "";

        FacesMessage infoMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "HistoricoInventario", "Registrado exitosamente");
        FacesContext.getCurrentInstance().addMessage("miItemHistorico", infoMensaje);

        return null;
    }

    public Item getItemGestion() {
        return itemGestion;
    }

    public void setItemGestion(Item itemGestion) {
        this.itemGestion = itemGestion;
    }

    public Item getItemEliminar() {
        return itemEliminar;
    }

    public void setItemEliminar(Item itemEliminar) {
        this.itemEliminar = itemEliminar;
    }

    public int getIdTipoItem() {
        return idTipoItem;
    }

    public void setIdTipoItem(int idTipoItem) {
        this.idTipoItem = idTipoItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public HistoricoInventario getHistoricoGestion() {
        return historicoGestion;
    }

    public void setHistoricoGestion(HistoricoInventario historicoGestion) {
        this.historicoGestion = historicoGestion;
    }

    public int getIdhistoricoInventario() {
        return idhistoricoInventario;
    }

    public void setIdhistoricoInventario(int idhistoricoInventario) {
        this.idhistoricoInventario = idhistoricoInventario;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public int getIdactivoproducto() {
        return idactivoproducto;
    }

    public void setIdactivoproducto(int idactivoproducto) {
        this.idactivoproducto = idactivoproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadohistorico_inventario() {
        return estadohistorico_inventario;
    }

    public void setEstadohistorico_inventario(String estadohistorico_inventario) {
        this.estadohistorico_inventario = estadohistorico_inventario;
    }

    public Date getFechahistorico_inventario() {
        return fechahistorico_inventario;
    }

    public void setFechahistorico_inventario(Date fechahistorico_inventario) {
        this.fechahistorico_inventario = fechahistorico_inventario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}
