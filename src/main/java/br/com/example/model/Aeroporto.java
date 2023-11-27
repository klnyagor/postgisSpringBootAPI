/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name = "aeroportos_2014")
public class Aeroporto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "objectid_1")
    private Integer objectid_1;
    @Column(name = "municdv")
    private String municdv;
    @Column(name = "uf")
    private String uf;
    @Column(name = "nome_uf")
    private String nome_uf;
    @Column(name = "nome_regia")
    private String nome_regia;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "pax2010")
    private Double pax2010;
    @Column(name = "internacio")
    private Double internacio;
    @Column(name = "geom")
    private Geometry geometria;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getObjectid_1() {
        return objectid_1;
    }

    public void setObjectid_1(Integer objectid_1) {
        this.objectid_1 = objectid_1;
    }

    public String getMunicdv() {
        return municdv;
    }

    public void setMunicdv(String municdv) {
        this.municdv = municdv;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome_uf() {
        return nome_uf;
    }

    public void setNome_uf(String nome_uf) {
        this.nome_uf = nome_uf;
    }

    public String getNome_regia() {
        return nome_regia;
    }

    public void setNome_regia(String nome_regia) {
        this.nome_regia = nome_regia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Double getPax2010() {
        return pax2010;
    }

    public void setPax2010(Double pax2010) {
        this.pax2010 = pax2010;
    }

    public Double getInternacio() {
        return internacio;
    }

    public void setInternacio(Double internacio) {
        this.internacio = internacio;
    }

    public Geometry getGeometria() {
        return geometria;
    }

    public void setGeometria(Geometry geometria) {
        this.geometria = geometria;
    }

    @Override
    public String toString() {
        return "Aeroporto{" + "gid=" + gid + ", objectid_1=" + objectid_1 + ", municdv=" + municdv + ", uf=" + uf + ", nome_uf=" + nome_uf + ", nome_regia=" + nome_regia + ", municipio=" + municipio + ", pax2010=" + pax2010 + ", internacio=" + internacio + ", geometria=" + geometria + '}';
    }

}
