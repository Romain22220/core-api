package com.coreapi.client;

import com.coreapi.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * L'interface FormationClient permet de communiquer avec le service Formation
 */
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


    // ✅ Valider ou refuser une inscription
    @PutMapping("/{id}/validation/{etudiantId}")
    void validerInscription(@PathVariable String id, @PathVariable String etudiantId, @RequestBody ValidationInscriptionDTO validation);

    // ✅ Récupérer la liste des UE d’une formation
    @GetMapping("/{id}/ue")
    List<UeDTO> getUEs(@PathVariable String id);

    // ✅ Choisir les UE optionnelles
    @PostMapping("/{id}/ue/options")
    void choisirUEOptions(@PathVariable String id, @RequestBody ChoixUEOptionsDTO choix);

    // ✅ Récupérer les groupes de TD et TP
    @GetMapping("/{id}/groupes")
    List<GroupeDTO> getGroupes(@PathVariable String id);

    // ✅ Assigner automatiquement les étudiants aux groupes
    @PutMapping("/{id}/groupes/assignation")
    void assignerGroupes(@PathVariable String id);
}