package com.coreapi.controller;

import com.coreapi.client.ManagerClient;
import com.coreapi.dto.ManagerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerClient managerClient;

    // 📌 Récupérer tous les managers
    @GetMapping
    public ResponseEntity<List<ManagerDTO>> getAllManagers() {
        return ResponseEntity.ok(managerClient.getAllManagers());
    }

    // 📌 Récupérer un manager par son id
    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable Long id) {
        return ResponseEntity.ok(managerClient.getManagerById(id));
    }

    // 📌 Créer un manager
    @PutMapping("/{id}")
    public ResponseEntity<ManagerDTO> updateManager(@PathVariable Long id, @RequestBody ManagerDTO managerDTO) {
        return ResponseEntity.ok(managerClient.updateManager(id, managerDTO));
    }

    // 📌 Supprimer un manager
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        managerClient.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}
