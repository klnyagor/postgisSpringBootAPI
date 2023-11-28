/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.example.model.Armazem;
import br.com.example.model.VO.ArmazemVO;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author klnyagor
 */

public interface ArmazemRepository extends JpaRepository<Armazem, Integer>{
    
    //-- Armazens no estado de 'sigla_uf'
    @Query(value = "SELECT new br.com.example.model.VO.ArmazemVO(am.gid, am.objectid, am.uf, am.municipio, am.cap_ton, am.geocodigo, am.geometria) FROM UnidadeFederativa uf, Armazem am WHERE ST_Within(am.geom, uf.geom)=true AND uf.sigla_uf = :sigla")
    List<ArmazemVO> armazemUF(String sigla);
    
    //-- Armazens na regiao de 'nm_regiao'
    @Query(value = "SELECT new br.com.example.model.VO.ArmazemVO(am.gid, am.objectid, am.uf, am.municipio, am.cap_ton, am.geocodigo, am.geometria) FROM UnidadeFederativa uf, Armazem am WHERE ST_Contains(uf.geom, am.geom)=true AND uf.nm_regiao = :regiao")
    List<ArmazemVO> armazemRegiao(String regiao);
    
}
