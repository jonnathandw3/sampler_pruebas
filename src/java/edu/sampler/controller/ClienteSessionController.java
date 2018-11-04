/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.Banda;
import edu.sampler.entity.Cliente;
import edu.sampler.entity.TipoCliente;
import edu.sampler.facade.BandaFacadeLocal;
import edu.sampler.facade.ClienteBandaFacadeLocal;
import edu.sampler.facade.ClienteFacadeLocal;
import edu.sampler.facade.TipoClienteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sebas
 */
@Named(value = "clienteSessionController")
@SessionScoped
public class ClienteSessionController implements Serializable {
    
    @EJB
    ClienteFacadeLocal clienteFacadeLocal;
    @EJB
    TipoClienteFacadeLocal tipoClienteFacadeLocal;
    @EJB
    ClienteBandaFacadeLocal clienteBandaFacadeLocal;
    @EJB
    BandaFacadeLocal BandaFacadeLocal;
    
    private Cliente clienteActualizar;
    private Banda bandaActualizar;
    private String tipoCliente;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String identificacion;
    private String fechaNacimiento;
    private String numeroFijo;
    private String numeroMovil;
    private String email;
    private String nombreBanda;
    
    private Date now = Calendar.getInstance().getTime();
    
    public ClienteSessionController() {
    }
    
    public List<Cliente> todosClientes() {
        return clienteFacadeLocal.findAll();
    }
    
    public List<TipoCliente> todosTiposCliente() {
        return tipoClienteFacadeLocal.findAll();
    }
    
    public String ingresarNuevoCliente() {
        Cliente clienteNuevo = new Cliente();
        
        LocalDate fecha = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ISO_DATE);
        Date date = java.sql.Date.valueOf(fecha);
        
        clienteNuevo.setTipoCliente(tipoClienteFacadeLocal.find(Integer.parseInt(tipoCliente)));
        clienteNuevo.setNombreCliente(primerNombre);
        clienteNuevo.setNombre2Cliente(segundoNombre);
        clienteNuevo.setApellidoCliente(primerApellido);
        clienteNuevo.setApellido2Cliente(segundoApellido);
        clienteNuevo.setIdentificacion(identificacion);
        clienteNuevo.setFechaNacimiento(date);
        clienteNuevo.setNumeroFijo(Integer.parseInt(numeroFijo));
        clienteNuevo.setNumeroMovil(Long.parseLong(numeroMovil));
        clienteNuevo.setEmail(email);
        clienteNuevo.setMulta(1);
        
        clienteFacadeLocal.create(clienteNuevo);
        
        //        JavaMail.sendClaves(clienteNuevo.getEmail(), clienteNuevo.getNombreCliente()+ " " + clienteNuevo.getApellidoCliente(), clienteNuevo.getEmail(), clienteNuevo.getIdentificacion());
        
        this.tipoCliente = "";
        this.primerNombre = "";
        this.segundoNombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.identificacion = "";
        this.fechaNacimiento = "";
        this.numeroFijo = "";
        this.numeroMovil = "";
        this.email = "";
        
        return null;
    }
    
    public String ingresarNuevaBanda(Banda banda) {

        Banda bandaNueva = new Banda();
        
        double numeroAleatori = Math.random() * 1000000;
        int codigoBanda = (int) numeroAleatori;
        String codigo = "A" + codigoBanda;
        

        bandaNueva.setCodigoBanda(codigo);
        bandaNueva.setFechaResgistro(now);
        bandaNueva.setNombreBanda(nombreBanda);
        
        
        BandaFacadeLocal.create(bandaNueva);
        
        //        JavaMail.sendClaves(clienteNuevo.getEmail(), clienteNuevo.getNombreCliente()+ " " + clienteNuevo.getApellidoCliente(), clienteNuevo.getEmail(), clienteNuevo.getIdentificacion());
        
        this.nombreBanda = "";
        return null;
    }
    
    public Cliente encontrarCliente(int idCliente) {
        Cliente resultado = clienteFacadeLocal.find(idCliente);
        return resultado;
    }
    
    public void actualizarCliente() {
        clienteFacadeLocal.edit(clienteActualizar);
        clienteActualizar = null;
    }
    
     public void actualizarBanda() {
        BandaFacadeLocal.edit(bandaActualizar);
        bandaActualizar = null;
    }
    
    public void eliminarCliente(Cliente clienteEliminar) {
        clienteFacadeLocal.remove(clienteEliminar);
        
    }
    public void eliminarBanda(Banda bandaEliminar) {
        BandaFacadeLocal.remove(bandaEliminar);
        
    }

    public Cliente getClienteActualizar() {
        return clienteActualizar;
    }

    public void setClienteActualizar(Cliente clienteActualizar) {
        this.clienteActualizar = clienteActualizar;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroFijo() {
        return numeroFijo;
    }

    public void setNumeroFijo(String numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public Date getNow() {
        return now;
    }

    public Banda getBandaActualizar() {
        return bandaActualizar;
    }

    public void setBandaActualizar(Banda bandaActualizar) {
        this.bandaActualizar = bandaActualizar;
    }

   
    
}
