/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "tipo_item")
@NamedQueries({
    @NamedQuery(name = "TipoItem.findAll", query = "SELECT t FROM TipoItem t")})
public class TipoItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoitem")
    private Integer idtipoitem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_item")
    private String nombreItem;
    @OneToMany(mappedBy = "idTipoItem")
    private Collection<Item> itemCollection;

    public TipoItem() {
    }

    public TipoItem(Integer idtipoitem) {
        this.idtipoitem = idtipoitem;
    }

    public TipoItem(Integer idtipoitem, String nombreItem) {
        this.idtipoitem = idtipoitem;
        this.nombreItem = nombreItem;
    }

    public Integer getIdtipoitem() {
        return idtipoitem;
    }

    public void setIdtipoitem(Integer idtipoitem) {
        this.idtipoitem = idtipoitem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoitem != null ? idtipoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoItem)) {
            return false;
        }
        TipoItem other = (TipoItem) object;
        if ((this.idtipoitem == null && other.idtipoitem != null) || (this.idtipoitem != null && !this.idtipoitem.equals(other.idtipoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sampler.entity.TipoItem[ idtipoitem=" + idtipoitem + " ]";
    }
    
}
