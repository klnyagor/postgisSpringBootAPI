/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.example.model.Rodovia;
import br.com.example.model.VO.RodoviaVO;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author klnyagor
 */

public interface RodoviaRepository extends JpaRepository<Rodovia, Integer>{
    
    //-- Rodovias contidas no estado 'sigla_uf'
    @Query(value="SELECT new br.com.example.model.VO.RodoviaVO(r.gid, r.objectid, r.descseg, r.tipopnv, r.codigo, r.geometria) FROM Rodovia r INNER JOIN UnidadeFederativa uf ON ST_WITHIN(r.geometria, uf.geometria)=true AND uf.sigla_uf = :sigla")
    List<RodoviaVO> rodoviasUF(String sigla);
        
    //-- Rodovias que cruzam estados vizinhos ao estado 'sigla_uf'
    @Query(value="SELECT new br.com.example.model.VO.RodoviaVO(r.gid, r.objectid, r.descseg, r.tipopnv, r.codigo, r.geometria) FROM Rodovia r INNER JOIN UnidadeFederativa uf ON ST_CROSSES(r.geometria, uf.geometria)=true AND uf.sigla_uf = :sigla JOIN UnidadeFederativa uf2 ON ST_CROSSES(r.geometria, uf2.geometria)=true WHERE ST_TOUCHES(uf2.geometria, uf.geometria)=true")
    List<RodoviaVO> rodoviaFronteiraUF(String sigla);
    
    //-- Rodovias que cruzam a fonteira do municipio 'nm_mun'
    @Query(value="SELECT DISTINCT new br.com.example.model.VO.RodoviaVO(r.gid, r.objectid, r.descseg, r.tipopnv, r.codigo, r.geometria) FROM Rodovia r INNER JOIN Municipio m ON ST_CROSSES(r.geometria, ST_BOUNDARY(m.geometria))=true WHERE m.nm_mun = :municipio")
    List<RodoviaVO> rodoviaFronteiraMunicipio(String municipio);
    
    //-- Rodovias que intersectam a cidade 'nm_mun'
    @Query(value="SELECT DISTINCT new br.com.example.model.VO.RodoviaVO(r.gid, r.objectid, r.descseg, r.tipopnv, r.codigo, r.geometria) FROM Rodovia r INNER JOIN Municipio m ON ST_INTERSECTS(m.geometria, r.geometria)=true WHERE m.nm_mun = :municipio")
    List<RodoviaVO> rodoviasMunicipio(String municipio);
        
    //-- Rodovias proximas dos pontos de fronteiras a uma distancia de 'metros' que cruzam a fronteira da cidade
    @Query(value= "SELECT new br.com.example.model.VO.RodoviaVO(r.gid, r.objectid, r.descseg, r.tipopnv, r.codigo, r.geometria) FROM Municipio m INNER JOIN PontosFronteira pf ON ST_CONTAINS(m.geometria,pf.geometria)=true INNER JOIN Rodovia r ON ST_CROSSES(r.geometria, ST_BOUNDARY(m.geometria))=true AND ST_DWITHIN(geography(r.geometria), geography(pf.geometria), 10000)=true")
    List<RodoviaVO> rodoviasPontosFronteiras();
}
