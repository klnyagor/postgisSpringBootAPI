/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.example.model.Hidrovias;
import br.com.example.model.VO.HidroviasVO;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author klnyagor
 */

public interface HidroviasRepository extends JpaRepository<Hidrovias, Integer>{
    
    //-- Hidrovias da região 'nm_regiao'
    @Query(value = "SELECT DISTINCT new br.com.example.model.VO.HidroviasVO(h.gid, h.objectid_1, h.geometria) FROM Hidrovias h INNER JOIN UnidadeFederativa uf ON ST_Intersects(uf.geometria, h.geometria)=true WHERE ST_ISVALID(h.geometria)=true AND uf.nm_regiao = :regiao ORDER BY h.gid")
    List<HidroviasVO> hidroviasRegiao(String regiao);
    
    //-- Hidrovias que estão completamente contidas em um estado por 'nm_regiao'
    @Query(value = "SELECT DISTINCT new br.com.example.model.VO.HidroviasVO(h.gid, h.objectid_1, h.geometria) FROM Hidrovias h INNER JOIN UnidadeFederativa uf ON ST_CONTAINS(uf.geometria, h.geometria)=true WHERE ST_ISVALID(h.geometria)=true AND uf.nm_regiao = :regiao ORDER BY h.gid")
    List<HidroviasVO> hidroviasContidasRegiao(String regiao);
    
    //-- Hidrovias que sobrepoem um estado por 'nm_regiao'
    @Query(value = "SELECT DISTINCT new br.com.example.model.VO.HidroviasVO(h.gid, h.objectid_1, h.geometria) FROM Hidrovias h INNER JOIN UnidadeFederativa uf ON ST_OVERLAPS(uf.geometria, h.geometria)=true WHERE ST_ISVALID(h.geometria)=true AND uf.nm_regiao = :regiao ORDER BY h.gid")
    List<HidroviasVO> hidroviasOverlapsUFPorRegiao(String regiao);
    
    //-- Hidrovias com area_km2 maior que 'km2'
    @Query(value="SELECT DISTINCT ST_AREA(geography(h.geometria))/1000000 FROM Hidrovias h WHERE ST_ISVALID(h.geometria)=true AND ST_AREA(geography(h.geometria))/1000000 >= :km2")
    List<Double> listarAreasKm2Hidrovias(Integer km2);
    
}
