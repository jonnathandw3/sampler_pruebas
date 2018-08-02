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
@Table(name = "banda")
@NamedQueries({
    @NamedQuery(name = "Banda.findAll", query = "SELECT b FROM Banda b")})
public class Banda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbanda")
    private Integer idbanda;
    @Basic(optional = false)
    @Column(name = "codigo_banda")
    private String codigoBanda;
    @Basic(optional = false)
    @Column(name = "nombre_banda")
    private String nombreBanda;
    @Basic(optional = false)
    @Column(name = "fecha_resgistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResgistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbanda")
    private Collection<ClienteBanda> clienteBandaCollection;

    public Banda() {
    }

    public Banda(Integer idbanda) {
        this.idbanda = idbanda;
    }

    public Banda(Integer idbanda, String codigoBanda, String nombreBanda, Date fechaResgistro) {
        this.idbanda = idbanda;
        this.codigoBanda = codigoBanda;
        this.nombreBanda = nombreBanda;
        this.fechaResgistro = fechaResgistro;
    }

    public Integer getIdbanda() {
        return idbanda;
    }

    public void setIdbanda(Integer idbanda) {
        this.idbanda = idbanda;
    }

    public String getCodigoBanda() {
        return codigoBanda;
    }

    public void setCodigoBanda(String codigoBanda) {
        this.codigoBanda = codigoBanda;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public Date getFechaResgistro() {
        return fechaResgistro;
    }

    public void setFechaResgistro(Date fechaResgistro) {
        this.fechaResgistro = fechaResgistro;
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
        hash += (idbanda != null ? idbanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banda)) {
            return false;
        }
        Banda other = (Banda) object;
        if ((this.idbanda == null && other.idbanda != null) || (this.idbanda != null && !this.idbanda.equals(other.idbanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.Banda[ idbanda=" + idbanda + " ]";
    }
    
}
