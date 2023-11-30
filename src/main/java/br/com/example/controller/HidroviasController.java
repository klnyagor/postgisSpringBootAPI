/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.VO.HidroviasVO;
import br.com.example.repository.HidroviasRepository;
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
public class HidroviasController {
    
    @Autowired
    private HidroviasRepository repository;
    
    @GetMapping("/hidroviasRegiao/{regiao}")
    public List<HidroviasVO> hidroviasRegiao(@PathVariable String regiao){
        return repository.hidroviasRegiao(regiao);
    }
    
    @GetMapping("/hidroviasContidas/{regiao}")
    public List<HidroviasVO> hidroviasContidas(@PathVariable String regiao){
        return repository.hidroviasContidasRegiao(regiao);
    }
    
    @GetMapping("/hidroviasOverlaps/{regiao}")
    public List<HidroviasVO> hidroviasOverlaps(@PathVariable String regiao){
        return repository.hidroviasOverlapsUFPorRegiao(regiao);
    }
    
    @GetMapping("/areasHidrovias/{km2}")
    public List<Double> listarAreasKm2Hidrovias(@PathVariable Integer km2){
        return repository.listarAreasKm2Hidrovias(km2);
    }
}
