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
public class HidroviasVO implements Serializable{
    private Integer gid;
    private Integer objectid_1;
    private Geometry geometria;
}
