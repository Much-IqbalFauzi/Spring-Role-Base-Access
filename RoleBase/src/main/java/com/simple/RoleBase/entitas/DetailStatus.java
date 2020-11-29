/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.RoleBase.entitas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cnugr
 */
@Entity
@Table(name = "detail_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailStatus.findAll", query = "SELECT d FROM DetailStatus d")
    , @NamedQuery(name = "DetailStatus.findById", query = "SELECT d FROM DetailStatus d WHERE d.id = :id")
    , @NamedQuery(name = "DetailStatus.findByTanggal", query = "SELECT d FROM DetailStatus d WHERE d.tanggal = :tanggal")})
public class DetailStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;
    @JoinColumn(name = "permintaan", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permintaan permintaan;

    public DetailStatus() {
    }

    public DetailStatus(Integer id) {
        this.id = id;
    }

    public DetailStatus(Integer id, Date tanggal) {
        this.id = id;
        this.tanggal = tanggal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Permintaan getPermintaan() {
        return permintaan;
    }

    public void setPermintaan(Permintaan permintaan) {
        this.permintaan = permintaan;
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
        if (!(object instanceof DetailStatus)) {
            return false;
        }
        DetailStatus other = (DetailStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simple.RoleBase.entitas.DetailStatus[ id=" + id + " ]";
    }
    
}
