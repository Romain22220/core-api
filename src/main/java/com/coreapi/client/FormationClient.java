package com.coreapi.client;

import com.coreapi.dto.FormationDTO;
import com.coreapi.dto.InscriptionFormationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "formation-api", url = "http://localhost:8080/formations")
public interface FormationClient {

    @GetMapping
    List<FormationDTO> getAllFormations();

    @GetMapping("/{id}")
    FormationDTO getFormationById(@PathVariable String id);

    @PostMapping
    FormationDTO createFormation(@RequestBody FormationDTO formationDTO);

    @PutMapping("/{id}")
    FormationDTO updateFormation(@PathVariable String id, @RequestBody FormationDTO formationDTO);

    @DeleteMapping("/{id}")
    void deleteFormation(@PathVariable String id);

    @PostMapping("/{id}/inscriptions")
    void inscrireEtudiant(@PathVariable String id, @RequestBody InscriptionFormationDTO inscription);
}