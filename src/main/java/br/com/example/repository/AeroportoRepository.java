/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Aeroporto;
import br.com.example.model.VO.AeroportoVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author klnyagor
 */

public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer>{
    
    //-- Aeroportos no estado 'sigla_uf'
    @Query(value = "SELECT new br.com.example.model.VO.AeroportoVO(a.gid, a.objectid_1, a.municdv, a.uf, a.nome_uf, a.nome_regia, a.municipio, a.pax2010, a.internacio, a.geometria) FROM Aeroporto a, UnidadeFederativa uf WHERE ST_Within(a.geometria, uf.geometria)=true and uf.sigla_uf = :sigla")
    List<AeroportoVO> aeroportosUF(String sigla);
    
    //-- Aeroportos na regiao 'nome_regia'
    @Query(value = "SELECT new br.com.example.model.VO.AeroportoVO(a.gid, a.objectid_1, a.municdv, a.uf, a.nome_uf, a.nome_regia, a.municipio, a.pax2010, a.internacio, a.geometria) FROM Aeroporto a, UnidadeFederativa uf WHERE ST_Contains(uf.geometria, a.geometria)=true and uf.nm_regiao = :regiao")
    List<AeroportoVO> aeroportosRegiao(String regiao);
    
    //-- Distancia entre Aeroportos por nome das cidades 'municipio'
    @Query(value = "SELECT ST_Distance(geography(a.geometria),geography(b.geometria)) FROM Aeroporto a, Aeroporto b WHERE a.municipio = :municipio1 and b.municipio = :municipio2")
    public Double distanciaAeroportos(String municipio1, String municipio2);
}
