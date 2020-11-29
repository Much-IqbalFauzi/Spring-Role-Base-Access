/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.RoleBase.entitas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cnugr
 */
@Entity
@Table(name = "permintaan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permintaan.findAll", query = "SELECT p FROM Permintaan p")
    , @NamedQuery(name = "Permintaan.findById", query = "SELECT p FROM Permintaan p WHERE p.id = :id")
    , @NamedQuery(name = "Permintaan.findByTanggal", query = "SELECT p FROM Permintaan p WHERE p.tanggal = :tanggal")
    , @NamedQuery(name = "Permintaan.findByStatus", query = "SELECT p FROM Permintaan p WHERE p.status = :status")
    , @NamedQuery(name = "Permintaan.findByProgress", query = "SELECT p FROM Permintaan p WHERE p.progress = :progress")})
public class Permintaan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "progress")
    private String progress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permintaan", fetch = FetchType.LAZY)
    private List<Barang> barangList;
    @JoinColumn(name = "karyawan", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Karyawan karyawan;
    @JoinColumn(name = "status_terkini", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status statusTerkini;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permintaan", fetch = FetchType.LAZY)
    private List<DetailStatus> detailStatusList;

    public Permintaan() {
    }

    public Permintaan(Integer id) {
        this.id = id;
    }

    public Permintaan(Integer id, Date tanggal, String status, String progress) {
        this.id = id;
        this.tanggal = tanggal;
        this.status = status;
        this.progress = progress;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @XmlTransient
    public List<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public Status getStatusTerkini() {
        return statusTerkini;
    }

    public void setStatusTerkini(Status statusTerkini) {
        this.statusTerkini = statusTerkini;
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
        if (!(object instanceof Permintaan)) {
            return false;
        }
        Permintaan other = (Permintaan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simple.RoleBase.entitas.Permintaan[ id=" + id + " ]";
    }
    
}
