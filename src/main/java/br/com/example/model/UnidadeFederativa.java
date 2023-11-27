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
@Table(name = "br_uf_2020")
public class UnidadeFederativa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "cd_uf")
    private Integer cd_uf;
    @Column(name = "nm_uf")
    private String nm_uf;
    @Column(name = "sigla_uf")
    private String sigla_uf;
    @Column(name = "nm_regiao")
    private String nm_regiao;
    @Column(name = "geom")
    private Geometry geometria;
    
    
}
