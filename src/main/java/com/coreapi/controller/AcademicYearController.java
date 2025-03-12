package com.coreapi.controller;

import com.coreapi.client.AcademicYearClient;
import com.coreapi.dto.AcademicYearDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic-years")
@RequiredArgsConstructor
public class AcademicYearController {

    private final AcademicYearClient academicYearClient;

    // 📌 Récupérer tous les academicYears
    @GetMapping
    public ResponseEntity<List<AcademicYearDTO>> getAllAcademicYears() {
        return ResponseEntity.ok(academicYearClient.getAllAcademicYears());
    }

    // 📌 Récupérer un academicYear par son id
    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> getAcademicYearById(@PathVariable Long id) {
        return ResponseEntity.ok(academicYearClient.getAcademicYearById(id));
    }

    // 📌 Créer un academicYear
    @PostMapping
    public ResponseEntity<AcademicYearDTO> createAcademicYear(@RequestBody AcademicYearDTO academicYearDTO) {
        return ResponseEntity.ok(academicYearClient.createAcademicYear(academicYearDTO));
    }

    // 📌 Mettre à jour un academicYear
    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> updateAcademicYear(@PathVariable Long id, @RequestBody AcademicYearDTO academicYearDTO) {
        return ResponseEntity.ok(academicYearClient.updateAcademicYear(id, academicYearDTO));
    }

    // 📌 Supprimer un academicYear
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYear(@PathVariable Long id) {
        academicYearClient.deleteAcademicYear(id);
        return ResponseEntity.noContent().build();
    }
}
