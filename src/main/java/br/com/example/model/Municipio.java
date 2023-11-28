package br.com.example.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.vividsolutions.jts.geom.Geometry;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "br_municipios_2020")
public class Municipio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "cd_mun")
    private String cod_mun;
    @Column(name = "nm_mun")
    private String nm_mun;
    @Column(name = "sigla_uf")
    private String sigla_uf;
    @Column(name = "area_km2")
    private double area_km2;    
    @Column(name = "geom")
    private Geometry geometria;

}
