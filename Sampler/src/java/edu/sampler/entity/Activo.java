/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "activo")
@NamedQueries({
    @NamedQuery(name = "Activo.findAll", query = "SELECT a FROM Activo a")})
public class Activo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactivo")
    private Integer idactivo;
    @Basic(optional = false)
    @Column(name = "codigo_activo")
    private String codigoActivo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "nombre_activo")
    private String nombreActivo;
    @JoinColumn(name = "id_sede", referencedColumnName = "idsede")
    @ManyToOne(optional = false)
    private Sede idSede;

    public Activo() {
    }

    public Activo(Integer idactivo) {
        this.idactivo = idactivo;
    }

    public Activo(Integer idactivo, String codigoActivo, int cantidad, double valor, String nombreActivo) {
        this.idactivo = idactivo;
        this.codigoActivo = codigoActivo;
        this.cantidad = cantidad;
        this.valor = valor;
        this.nombreActivo = nombreActivo;
    }

    public Integer getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(Integer idactivo) {
        this.idactivo = idactivo;
    }

    public String getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(String codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNombreActivo() {
        return nombreActivo;
    }

    public void setNombreActivo(String nombreActivo) {
        this.nombreActivo = nombreActivo;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivo != null ? idactivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activo)) {
            return false;
        }
        Activo other = (Activo) object;
        if ((this.idactivo == null && other.idactivo != null) || (this.idactivo != null && !this.idactivo.equals(other.idactivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.Activo[ idactivo=" + idactivo + " ]";
    }
    
}
