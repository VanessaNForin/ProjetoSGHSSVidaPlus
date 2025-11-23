package com.forin.apividaplus.controllers;

import com.forin.apividaplus.dtos.HospitalInputDTO;
import com.forin.apividaplus.dtos.HospitalResponseDTO;
import com.forin.apividaplus.dtos.LeitoResponseDTO;
import com.forin.apividaplus.models.infraestrutura.Hospital;
import com.forin.apividaplus.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.forin.apividaplus.mappers.HospitalMapper.toDTO;

@RestController
@RequestMapping("/hospitais")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<HospitalResponseDTO> cadastraHospital(@RequestBody HospitalInputDTO hospital){
        HospitalResponseDTO hospitalCriado = hospitalService.cadastrarHospital(hospital);

        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<LeitoResponseDTO>> listarTodosOsLeitos(@PathVariable("id") String idHospital){
        List<LeitoResponseDTO> leitosEncontrados = hospitalService.listarTodosOsLeitos(idHospital);

        return ResponseEntity.status(HttpStatus.OK).body(leitosEncontrados);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarHospital(@PathVariable("id") String idHospital){
        hospitalService.desativarHospital(idHospital);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
