package com.coreapi.controller;

import com.coreapi.client.FormationClient;
import com.coreapi.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
@RequiredArgsConstructor
public class FormationController {

    private final FormationClient formationClient;

    // ✅ Récupérer toutes les formations
    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        return ResponseEntity.ok(formationClient.getAllFormations());
    }

    // ✅ Récupérer une formation par son id
    @GetMapping("/{id}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable String id) {
        return ResponseEntity.ok(formationClient.getFormationById(id));
    }

    // ✅ Créer une formation
    @PostMapping
    public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formationDTO) {
        return ResponseEntity.ok(formationClient.createFormation(formationDTO));
    }

    // ✅ Mettre à jour une formation
    @PutMapping("/{id}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable String id, @RequestBody FormationDTO formationDTO) {
        return ResponseEntity.ok(formationClient.updateFormation(id, formationDTO));
    }

    // ✅ Supprimer une formation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable String id) {
        formationClient.deleteFormation(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ inscrire un étudiant à une formation
    @PostMapping("/{id}/inscription")
    public ResponseEntity<Void> inscrireEtudiant(@PathVariable String id, @RequestBody InscriptionFormationDTO inscription) {
        formationClient.inscrireEtudiant(id, inscription);
        return ResponseEntity.status(201).build();
    }

    // ✅ Valider ou refuser une inscription
    @PutMapping("/{id}/validation/{etudiantId}")
    public ResponseEntity<Void> validerInscription(@PathVariable String id, @PathVariable String etudiantId, @RequestBody ValidationInscriptionDTO validation) {
        formationClient.validerInscription(id, etudiantId, validation);
        return ResponseEntity.ok().build();
    }

    // ✅ Récupérer la liste des UE d’une formation
    @GetMapping("/{id}/ue")
    public ResponseEntity<List<UeDTO>> getUEs(@PathVariable String id) {
        return ResponseEntity.ok(formationClient.getUEs(id));
    }

    // ✅ Choisir les UE optionnelles
    @PostMapping("/{id}/ue/options")
    public ResponseEntity<Void> choisirUEOptions(@PathVariable String id, @RequestBody ChoixUEOptionsDTO choix) {
        formationClient.choisirUEOptions(id, choix);
        return ResponseEntity.ok().build();
    }

    // ✅ Récupérer les groupes de TD et TP
    @GetMapping("/{id}/groupes")
    public ResponseEntity<List<GroupeDTO>> getGroupes(@PathVariable String id) {
        return ResponseEntity.ok(formationClient.getGroupes(id));
    }

    // ✅ Assigner automatiquement les étudiants aux groupes
    @PutMapping("/{id}/groupes/assignation")
    public ResponseEntity<Void> assignerGroupes(@PathVariable String id) {
        formationClient.assignerGroupes(id);
        return ResponseEntity.ok().build();
    }
}
