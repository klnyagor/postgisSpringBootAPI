/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.VO.RodoviaVO;
import br.com.example.repository.RodoviaRepository;
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
public class RodoviaController {
    
    @Autowired
    private RodoviaRepository repository;
    
    @GetMapping("/rodoviasUF/{sigla}")
    public List<RodoviaVO> rodoviasUF(@PathVariable String sigla){
        return repository.rodoviasUF(sigla);
    }
    
    @GetMapping("/rodoviaFronteiraUF/{sigla}")
    public List<RodoviaVO> rodoviasFronteiraUF(@PathVariable String sigla){
        return repository.rodoviaFronteiraUF(sigla);
    }
    
    @GetMapping("/rodoviaFronteiraMunicipio/{municipio}")
    public List<RodoviaVO> rodoviasFronteiraMunicipio(@PathVariable String municipio){
        return repository.rodoviaFronteiraMunicipio(municipio);
    }
    
    @GetMapping("/rodoviasMunicipio/{municipio}")
    public List<RodoviaVO> rodoviasMunicipio(@PathVariable String municipio){
        return repository.rodoviasMunicipio(municipio);
    }
    
    @GetMapping("/rodoviasPontosFronteiras")
    public List<RodoviaVO> rodoviasPontosFronteiras(){
        return repository.rodoviasPontosFronteiras();
    }
}
