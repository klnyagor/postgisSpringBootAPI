package br.com.example.controller;

import java.util.List;
import br.com.example.repository.MunicipioRepository;
import br.com.example.model.VO.MunicipioVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "BDGeo API", version = "1.0", description = "Dados Geograficos"))
public class MunicipioController {
    
    @Autowired
    private MunicipioRepository repository;
     
//    @GetMapping("/municipiosVizinhos/{nome}")
//    public List<MunicipioVO> municipiosVizinhos(@PathVariable String nome){
//        List<MunicipioVO> result = repository.listarMunicipiosVizinhos(nome);
//        return result;
//    }
//   
//    @GetMapping("/distanciaEntreMunicipios/{municipioA}/{municipioB}")
//     public Double distanciaEntreMunicipios(@PathVariable String municipioA, @PathVariable String municipioB){
//        double result = repository.distanciaEntreMunicipios(municipioA, municipioB);
//        return result;
//    }
    
    @GetMapping("/municipiosAeroportos/{sigla}")
    public List<MunicipioVO> municipiosComAeroportoUF(@PathVariable String sigla){
        return repository.listarCidadesComAeroportosPorUF(sigla);
    }
    
    @GetMapping("/municipiosAeroportosRegiao/{regiao}")
    public List<MunicipioVO> municipiosComAeroportosRegiao(@PathVariable String regiao){
        return repository.listarCidadesComAeroportosPorRegiao(regiao);
    }
    
    @GetMapping("/municipiosArmazens/{sigla}")
    public List<MunicipioVO> municipiosComArmazemUF(@PathVariable String sigla){
        return repository.listarCidadesComArmazemPorUF(sigla);
    }
    
    @GetMapping("/municipiosArmazensRegiao/{regiao}")
    public List<MunicipioVO> municipiosComArmazemRegiao(@PathVariable String regiao){
        return repository.listarCidadesComArmazemPorRegiao(regiao);
    }
    
    @GetMapping("/municipiosPossuem/{regiao}")
    public List<MunicipioVO> municipiosPossuem(@PathVariable String regiao){
        return repository.listarCidadesPossuem(regiao);
    }
    
    @GetMapping("/municipiosFronteira")
    public List<MunicipioVO> municipiosFronteira(){
        return repository.listarCidadesPontosFronteira();
    }
    
}