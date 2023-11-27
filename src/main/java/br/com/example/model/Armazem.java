package br.com.example.model;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author klnyagor
 */

@Entity
@Table(name = "armazens_2014")
public class Armazem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "objectid")
    private Integer objectid;
    @Column(name = "uf")
    private String uf;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "cap_ton")
    private Double cap_ton;
    @Column(name = "geocodigo")
    private Integer geocodigo;
    @Column(name = "geom")
    private Geometry geometria;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Double getCap_ton() {
        return cap_ton;
    }

    public void setCap_ton(Double cap_ton) {
        this.cap_ton = cap_ton;
    }

    public Integer getGeocodigo() {
        return geocodigo;
    }

    public void setGeocodigo(Integer geocodigo) {
        this.geocodigo = geocodigo;
    }

    public Geometry getGeometria() {
        return geometria;
    }

    public void setGeometria(Geometry geometria) {
        this.geometria = geometria;
    }

    @Override
    public String toString() {
        return "Armazem{" + "gid=" + gid + ", objectid=" + objectid + ", uf=" + uf + ", municipio=" + municipio + ", cap_ton=" + cap_ton + ", geocodigo=" + geocodigo + ", geometria=" + geometria + '}';
    }
    
}
