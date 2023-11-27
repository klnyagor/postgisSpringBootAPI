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
@Table(name = "pontos_fronteira_2014")
public class PontosFronteira implements Serializable{
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
    @Column(name = "administra")
    private String administra;
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

    public String getAdministra() {
        return administra;
    }

    public void setAdministra(String administra) {
        this.administra = administra;
    }

    public Geometry getGeometria() {
        return geometria;
    }

    public void setGeometria(Geometry geometria) {
        this.geometria = geometria;
    }

    @Override
    public String toString() {
        return "PontosFronteira{" + "gid=" + gid + ", objectid_1=" + objectid_1 + ", municdv=" + municdv + ", uf=" + uf + ", nome_uf=" + nome_uf + ", nome_regia=" + nome_regia + ", municipio=" + municipio + ", administra=" + administra + ", geometria=" + geometria + '}';
    }
    
    
}
