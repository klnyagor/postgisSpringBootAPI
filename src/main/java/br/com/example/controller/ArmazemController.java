/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.controller;

import br.com.example.model.VO.ArmazemVO;
import br.com.example.repository.ArmazemRepository;
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
public class ArmazemController {
    
    @Autowired
    private ArmazemRepository repository;
    
    @GetMapping("/armazensUF/{sigla}")
    public List<ArmazemVO> armazensUF(@PathVariable String sigla){
        return repository.armazemUF(sigla);
    }
    
    @GetMapping("/armazensRegiao/{regiao}")
    public List<ArmazemVO> armazensRegiao(@PathVariable String regiao){
        return repository.armazemRegiao(regiao);
    }
}
