/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.RoleBase.entitas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cnugr
 */
@Entity
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findById", query = "SELECT s FROM Status s WHERE s.id = :id")
    , @NamedQuery(name = "Status.findByNama", query = "SELECT s FROM Status s WHERE s.nama = :nama")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusTerkini", fetch = FetchType.LAZY)
    private List<Permintaan> permintaanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status", fetch = FetchType.LAZY)
    private List<DetailStatus> detailStatusList;

    public Status() {
    }

    public Status(Integer id) {
        this.id = id;
    }

    public Status(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @XmlTransient
    public List<Permintaan> getPermintaanList() {
        return permintaanList;
    }

    public void setPermintaanList(List<Permintaan> permintaanList) {
        this.permintaanList = permintaanList;
    }

    @XmlTransient
    public List<DetailStatus> getDetailStatusList() {
        return detailStatusList;
    }

    public void setDetailStatusList(List<DetailStatus> detailStatusList) {
        this.detailStatusList = detailStatusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simple.RoleBase.entitas.Status[ id=" + id + " ]";
    }
    
}
