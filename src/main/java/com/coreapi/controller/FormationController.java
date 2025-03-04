package com.coreapi.controller;

import com.coreapi.client.FormationClient;
import com.coreapi.dto.FormationDTO;
import com.coreapi.dto.InscriptionFormationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
@RequiredArgsConstructor
public class FormationController {

    private final FormationClient formationClient;

    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        return ResponseEntity.ok(formationClient.getAllFormations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable String id) {
        return ResponseEntity.ok(formationClient.getFormationById(id));
    }

    @PostMapping
    public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formationDTO) {
        return ResponseEntity.ok(formationClient.createFormation(formationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable String id, @RequestBody FormationDTO formationDTO) {
        return ResponseEntity.ok(formationClient.updateFormation(id, formationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable String id) {
        formationClient.deleteFormation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/inscription")
    public ResponseEntity<Void> inscrireEtudiant(@PathVariable String id, @RequestBody InscriptionFormationDTO inscription) {
        formationClient.inscrireEtudiant(id, inscription);
        return ResponseEntity.status(201).build();
    }
}
