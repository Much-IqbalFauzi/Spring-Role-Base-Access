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
@Table(name = "karyawan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findById", query = "SELECT k FROM Karyawan k WHERE k.id = :id")
    , @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama")
    , @NamedQuery(name = "Karyawan.findByTanggalLahir", query = "SELECT k FROM Karyawan k WHERE k.tanggalLahir = :tanggalLahir")
    , @NamedQuery(name = "Karyawan.findByJenisKelamin", query = "SELECT k FROM Karyawan k WHERE k.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Karyawan.findByPosisi", query = "SELECT k FROM Karyawan k WHERE k.posisi = :posisi")
    , @NamedQuery(name = "Karyawan.findByEmail", query = "SELECT k FROM Karyawan k WHERE k.email = :email")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    @Basic(optional = false)
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
    @Basic(optional = false)
    @Column(name = "posisi")
    private String posisi;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "karyawan", fetch = FetchType.LAZY)
    private List<Permintaan> permintaanList;

    public Karyawan() {
    }

    public Karyawan(Integer id) {
        this.id = id;
    }

    public Karyawan(Integer id, String nama, Date tanggalLahir, String jenisKelamin, String posisi, String email) {
        this.id = id;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.posisi = posisi;
        this.email = email;
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

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Permintaan> getPermintaanList() {
        return permintaanList;
    }

    public void setPermintaanList(List<Permintaan> permintaanList) {
        this.permintaanList = permintaanList;
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
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.simple.RoleBase.entitas.Karyawan[ id=" + id + " ]";
    }
    
}
