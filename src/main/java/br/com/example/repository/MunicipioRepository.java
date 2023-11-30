/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Municipio;
import br.com.example.model.VO.MunicipioVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author caian
 * @author klnyagor 
 */
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{
    
//    @Query(value = "select new br.com.example.model.MunicipioVO(mb.codigo,mb.nome,mb.geometria) from Municipio ma, Municipio mb where touches(ma.geometria, mb.geometria) = true and ma.nome = :nome")
//    List<MunicipioVO> listarMunicipiosVizinhos(String nome);
//     
//    @Query(value ="select distance(geography(ma.geometria), geography(mb.geometria)) from Municipio ma, Municipio mb where ma.nome = :municipioA  and   mb.nome = :municipioB")
//    public Double distanciaEntreMunicipios(String municipioA, String municipioB);
    
    //-- Cidades que possuem aeroportos, no estado de 'sigla_uf'
    @Query(value = "SELECT new br.com.example.model.VO.MunicipioVO(m.gid,m.cod_mun,m.nm_mun,m.sigla_uf,m.area_km2,m.geometria) FROM Municipio m, Aeroporto a WHERE ST_Within(a.geometria, m.geometria)=true AND m.sigla_uf = :sigla")
    List<MunicipioVO> listarCidadesComAeroportosPorUF(String sigla);
    
    //-- Cidades com aeroportos na região 'nome_regia'
    @Query(value = "SELECT new br.com.example.model.VO.MunicipioVO(m.gid,m.cod_mun,m.nm_mun,m.sigla_uf,m.area_km2,m.geometria) FROM Municipio m, Aeroporto a WHERE ST_Contains(m.geometria, a.geometria)=true AND a.nome_regia = :regiao")
    List<MunicipioVO> listarCidadesComAeroportosPorRegiao(String regiao);
    
    //-- Cidades que possuem armazem, no estado de 'sigla_uf'
    @Query(value = "SELECT new br.com.example.model.VO.MunicipioVO(m.gid,m.cod_mun,m.nm_mun,m.sigla_uf,m.area_km2,m.geometria) FROM Municipio m, Armazem am WHERE ST_WITHIN(am.geometria, m.geometria)=true AND m.sigla_uf = :sigla")
    List<MunicipioVO> listarCidadesComArmazemPorUF(String sigla);
    
    //-- Cidades com armazens na região 'nome_regia'
    @Query(value = "SELECT new br.com.example.model.VO.MunicipioVO(m.gid,m.cod_mun,m.nm_mun,m.sigla_uf,m.area_km2,m.geometria) FROM Municipio m INNER JOIN UnidadeFederativa uf ON ST_WITHIN(m.geometria, uf.geometria)=true INNER JOIN Armazem am ON ST_WITHIN(am.geometria, m.geometria)=true WHERE uf.nm_regiao = :regiao ORDER BY m.sigla_uf")
    List<MunicipioVO> listarCidadesComArmazemPorRegiao(String regiao);
    
    //-- Cidades que possuem Aeroportos, armazens e rodovias por nm_regiao
    @Query(value = "SELECT new br.com.example.model.VO.MunicipioVO(m.gid,m.cod_mun,m.nm_mun,m.sigla_uf,m.area_km2,m.geometria) FROM Municipio m INNER JOIN Aeroporto a ON ST_WITHIN(a.geometria, m.geometria)=true INNER JOIN Armazem am ON ST_WITHIN(am.geometria, m.geometria)=true INNER JOIN Rodovia r ON ST_INTERSECTS(r.geometria, m.geometria)=true INNER JOIN UnidadeFederativa uf ON ST_CONTAINS(uf.geometria, m.geometria)=true WHERE uf.nm_regiao = :regiao")
    List<MunicipioVO> listarCidadesPossuem(String regiao);
    
    //-- Cidades geograficamente marcadas com Pontos de Fronteira
    @Query(value = "SELECT new br.com.example.model.VO.MunicipioVO(m.gid,m.cod_mun,m.nm_mun,m.sigla_uf,m.area_km2,m.geometria) FROM Municipio m, PontosFronteira pf WHERE ST_WITHIN(pf.geometria, m.geometria)=true")
    List<MunicipioVO> listarCidadesPontosFronteira();
    
}
