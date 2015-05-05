/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sau-mfh
 */
@Entity
@Table(name = "jenis_surat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisSurat.findAll", query = "SELECT j FROM JenisSurat j"),
    @NamedQuery(name = "JenisSurat.findByIdjenisSurat", query = "SELECT j FROM JenisSurat j WHERE j.idjenisSurat = :idjenisSurat"),
    @NamedQuery(name = "JenisSurat.findByNamaJenis", query = "SELECT j FROM JenisSurat j WHERE j.namaJenis = :namaJenis")})
public class JenisSurat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjenis_surat")
    private Integer idjenisSurat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nama_jenis")
    private String namaJenis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jenisSuratIdjenisSurat")
    private Collection<KolomSurat> kolomSuratCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jenisSuratIdjenisSurat")
    private Collection<Surat> suratCollection;

    public JenisSurat() {
    }

    public JenisSurat(Integer idjenisSurat) {
        this.idjenisSurat = idjenisSurat;
    }

    public JenisSurat(Integer idjenisSurat, String namaJenis) {
        this.idjenisSurat = idjenisSurat;
        this.namaJenis = namaJenis;
    }

    public Integer getIdjenisSurat() {
        return idjenisSurat;
    }

    public void setIdjenisSurat(Integer idjenisSurat) {
        this.idjenisSurat = idjenisSurat;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    @XmlTransient
    public Collection<KolomSurat> getKolomSuratCollection() {
        return kolomSuratCollection;
    }

    public void setKolomSuratCollection(Collection<KolomSurat> kolomSuratCollection) {
        this.kolomSuratCollection = kolomSuratCollection;
    }

    @XmlTransient
    public Collection<Surat> getSuratCollection() {
        return suratCollection;
    }

    public void setSuratCollection(Collection<Surat> suratCollection) {
        this.suratCollection = suratCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjenisSurat != null ? idjenisSurat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JenisSurat)) {
            return false;
        }
        JenisSurat other = (JenisSurat) object;
        if ((this.idjenisSurat == null && other.idjenisSurat != null) || (this.idjenisSurat != null && !this.idjenisSurat.equals(other.idjenisSurat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.JenisSurat[ idjenisSurat=" + idjenisSurat + " ]";
    }
    
}
