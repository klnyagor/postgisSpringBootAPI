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
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author klnyagor
 */

@Data
@AllArgsConstructor
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

}
