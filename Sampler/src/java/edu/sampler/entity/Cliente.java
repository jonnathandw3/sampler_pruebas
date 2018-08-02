/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "nombre2_cliente")
    private String nombre2Cliente;
    @Basic(optional = false)
    @Column(name = "apellido_cliente")
    private String apellidoCliente;
    @Basic(optional = false)
    @Column(name = "apellido2_cliente")
    private String apellido2Cliente;
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "numero_fijo")
    private int numeroFijo;
    @Basic(optional = false)
    @Column(name = "numero_movil")
    private int numeroMovil;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "multa")
    private String multa;
    @JoinColumn(name = "tipo_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCliente tipoCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<ClienteBanda> clienteBandaCollection;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Integer idcliente, String nombreCliente, String nombre2Cliente, String apellidoCliente, String apellido2Cliente, String identificacion, Date fechaNacimiento, int numeroFijo, int numeroMovil, String email, String multa) {
        this.idcliente = idcliente;
        this.nombreCliente = nombreCliente;
        this.nombre2Cliente = nombre2Cliente;
        this.apellidoCliente = apellidoCliente;
        this.apellido2Cliente = apellido2Cliente;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroFijo = numeroFijo;
        this.numeroMovil = numeroMovil;
        this.email = email;
        this.multa = multa;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombre2Cliente() {
        return nombre2Cliente;
    }

    public void setNombre2Cliente(String nombre2Cliente) {
        this.nombre2Cliente = nombre2Cliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getApellido2Cliente() {
        return apellido2Cliente;
    }

    public void setApellido2Cliente(String apellido2Cliente) {
        this.apellido2Cliente = apellido2Cliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumeroFijo() {
        return numeroFijo;
    }

    public void setNumeroFijo(int numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    public int getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(int numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Collection<ClienteBanda> getClienteBandaCollection() {
        return clienteBandaCollection;
    }

    public void setClienteBandaCollection(Collection<ClienteBanda> clienteBandaCollection) {
        this.clienteBandaCollection = clienteBandaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
