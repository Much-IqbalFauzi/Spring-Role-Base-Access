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
@Table(name = "barang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b")
    , @NamedQuery(name = "Barang.findById", query = "SELECT b FROM Barang b WHERE b.id = :id")
    , @NamedQuery(name = "Barang.findByNama", query = "SELECT b FROM Barang b WHERE b.nama = :nama")
    , @NamedQuery(name = "Barang.findByHarga", query = "SELECT b FROM Barang b WHERE b.harga = :harga")
    , @NamedQuery(name = "Barang.findByTanggalBeli", query = "SELECT b FROM Barang b WHERE b.tanggalBeli = :tanggalBeli")})
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "harga")
    private int harga;
    @Basic(optional = false)
    @Column(name = "tanggal_beli")
    @Temporal(TemporalType.DATE)
    private Date tanggalBeli;
    @JoinColumn(name = "permintaan", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permintaan permintaan;

    public Barang() {
    }

    public Barang(Integer id) {
        this.id = id;
    }

    public Barang(Integer id, String nama, int harga, Date tanggalBeli) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.tanggalBeli = tanggalBeli;
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Date getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(Date tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
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
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simple.RoleBase.entitas.Barang[ id=" + id + " ]";
    }
    
}
