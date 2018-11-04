/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "tipo_documento")
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipodocumento")
    private Integer idTipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private Collection<Usuario> usuarioCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }

    public TipoDocumento(Integer idTipodocumento, String tipoDocumento, String descripcion) {
        this.idTipodocumento = idTipodocumento;
        this.tipoDocumento = tipoDocumento;
        this.descripcion = descripcion;
    }

    public Integer getIdTipodocumento() {
        return idTipodocumento;
    }

    public void setIdTipodocumento(Integer idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipodocumento != null ? idTipodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idTipodocumento == null && other.idTipodocumento != null) || (this.idTipodocumento != null && !this.idTipodocumento.equals(other.idTipodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.TipoDocumento[ idTipodocumento=" + idTipodocumento + " ]";
    }
    
}
