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
public class PontosFronteiraVO implements Serializable{
    private Integer gid;
    private Integer objectid_1;
    private String municdv;
    private String uf;
    private String nome_uf;
    private String nome_regia;
    private String municipio;
    private String administra;
    private Geometry geometria;
}
