/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.HistoricoInventario;
import edu.sampler.entity.Item;
import edu.sampler.facade.HistoricoInventarioFacadeLocal;
import edu.sampler.facade.ItemFacadeLocal;
import edu.sampler.facade.TipoItemFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author sebas
 */
@Named(value = "servicioSessionController")
@SessionScoped
public class ServicioSessionController implements Serializable {

    //daisy
    @EJB
    private ItemFacadeLocal itemFacadeLocal;
    @EJB
    private TipoItemFacadeLocal tipoItemFacadeLocal;
    @EJB
    private HistoricoInventarioFacadeLocal historicoInventarioFacadeLocal;

    private Item itemGestion;
    private Item servicioEliminar;
    private int idTipoItem = 2;
    private String nombreItem;
    private String descripcion;
    private double valorUnitario;
    private String fechaInicio;
    private String fechaFin;
    private String tipo;
    //historico
    private HistoricoInventario historicoGestion;
    private String estadoServicio;
    private String estadohistorico_inventario;
    //daisy   

    public ServicioSessionController() {
    }

    //daisy
    public String actualizarEstadoServicio(Item itemActualizar) {
//        itemActualizar.setEstadoServicio(Character "2");
        itemFacadeLocal.edit(itemActualizar);
        ingresarServicioHistorico();
        return null;
    }

    public String actualizarServicio() {
        itemFacadeLocal.edit(itemGestion);

        return null;
    }

    public String actualizarHistorico() {
        historicoInventarioFacadeLocal.edit(historicoGestion);
        return null;
    }

    public List<Item> todosServicios() {
        return itemFacadeLocal.todosServicios();
    }

    public String eliminarServicio(Item ServicioEliminar) {
        itemFacadeLocal.remove(ServicioEliminar);
        return "";
    }
    private java.util.Date dates = new java.util.Date();
    private long fechaSis = dates.getTime();
    private Date now = new Date(fechaSis);

    public String ingresarNuevoServicio() {

        LocalDate fecha = LocalDate.parse(fechaInicio, DateTimeFormatter.ISO_DATE);
        Date inicio = java.sql.Date.valueOf(fecha);

        LocalDate fechaDos = LocalDate.parse(fechaFin, DateTimeFormatter.ISO_DATE);
        Date fechaFinal = java.sql.Date.valueOf(fechaDos);

        Item itemServicio = new Item();

        itemServicio.setIdTipoItem(tipoItemFacadeLocal.find(this.idTipoItem));
        itemServicio.setNombreItem(nombreItem);
        itemServicio.setDescripcion(descripcion);
        itemServicio.setValorUnitario(valorUnitario);
        itemServicio.setFechaInicio(inicio);
        itemServicio.setFechaFinal(fechaFinal);
        itemFacadeLocal.create(itemServicio);
        ingresarServicioHistorico();

        this.nombreItem = "";
        this.descripcion = "";
        this.valorUnitario = 0;
        this.fechaInicio = "";
        this.fechaFin = "";

        FacesMessage infoMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item", "Registrado exitosamente");
        FacesContext.getCurrentInstance().addMessage("miItem", infoMensaje);

        return null;
    }

    public String ingresarServicioHistorico() {

        java.util.Date fecha = new Date();
        HistoricoInventario itemHistorico = new HistoricoInventario();

        double numeroAleatori = Math.random() * 10000;
        int CodigoHistoricoInt = (int) numeroAleatori;
        String idhistorico = "" + CodigoHistoricoInt;

        itemHistorico.setIdactivoproducto(Integer.parseInt(idhistorico));
        itemHistorico.setEstadohistoricoInventario(estadohistorico_inventario);
        itemHistorico.setFechahistoricoInventario(fecha);
        itemHistorico.setTipo("servicio");
        historicoInventarioFacadeLocal.create(itemHistorico);

        this.estadohistorico_inventario = "";

        FacesMessage infoMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "HistoricoInventario", "Registrado exitosamente");
        FacesContext.getCurrentInstance().addMessage("miItemHistorico", infoMensaje);

        return null;
    }
    //daisy

    public Item getItemGestion() {
        return itemGestion;
    }

    public void setItemGestion(Item itemGestion) {
        this.itemGestion = itemGestion;
    }

    public Item getServicioEliminar() {
        return servicioEliminar;
    }

    public void setServicioEliminar(Item servicioEliminar) {
        this.servicioEliminar = servicioEliminar;
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

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public HistoricoInventario getHistoricoGestion() {
        return historicoGestion;
    }

    public void setHistoricoGestion(HistoricoInventario historicoGestion) {
        this.historicoGestion = historicoGestion;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public String getEstadohistorico_inventario() {
        return estadohistorico_inventario;
    }

    public void setEstadohistorico_inventario(String estadohistorico_inventario) {
        this.estadohistorico_inventario = estadohistorico_inventario;
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

}
