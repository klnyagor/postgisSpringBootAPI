/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model.VO;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.vividsolutions.jts.geom.Geometry;


/**
 *
 * @author caian
 */
@Data
@AllArgsConstructor
public class MunicipioVO implements Serializable{
    private Integer gid;
    private String cod_mun;
    private String nm_mun;
    private String sigla_uf;
    private double area_km2;    
    private Geometry geometria;
}
