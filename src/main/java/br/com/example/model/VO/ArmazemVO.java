/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model.VO;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author klnyagor
 */

@Data
@AllArgsConstructor
public class ArmazemVO implements Serializable{
    private Integer gid;
    private Integer objectid;
    private String uf;
    private String municipio;
    private Double cap_ton;
    private Integer geocodigo;
    private Geometry geometria;
}
