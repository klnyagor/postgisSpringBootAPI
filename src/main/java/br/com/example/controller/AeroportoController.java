/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.VO.AeroportoVO;
import br.com.example.repository.AeroportoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author klnyagor
 */

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "BDGeo API", version = "1.0", description = "Dados Geograficos"))
public class AeroportoController {
    
    @Autowired
    private AeroportoRepository repository;
    
    @GetMapping("/aeroportosUF/{sigla}")
    public List<AeroportoVO> aeroportosUF(@PathVariable String sigla){
        return repository.listarAeroportosUF(sigla);
    }
    
    @GetMapping("/aeroportosRegiao/{regiao}")
    public List<AeroportoVO> aeroportosRegiao(@PathVariable String regiao){
        return repository.listarAeroportosRegiao(regiao);
    }
    
    @GetMapping("/distanciaEntreAeroportos/{municipioA}/{municipioB}")
    public Double distanciaAeroportos(@PathVariable String municipioA, @PathVariable String municipioB){
        return repository.distanciaAeroportos(municipioA, municipioB);
    }
    
}
