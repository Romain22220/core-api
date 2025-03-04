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

    @GetMapping
    public ResponseEntity<List<AcademicYearDTO>> getAllAcademicYears() {
        return ResponseEntity.ok(academicYearClient.getAllAcademicYears());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> getAcademicYearById(@PathVariable Long id) {
        return ResponseEntity.ok(academicYearClient.getAcademicYearById(id));
    }

    @PostMapping
    public ResponseEntity<AcademicYearDTO> createAcademicYear(@RequestBody AcademicYearDTO academicYearDTO) {
        return ResponseEntity.ok(academicYearClient.createAcademicYear(academicYearDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> updateAcademicYear(@PathVariable Long id, @RequestBody AcademicYearDTO academicYearDTO) {
        return ResponseEntity.ok(academicYearClient.updateAcademicYear(id, academicYearDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYear(@PathVariable Long id) {
        academicYearClient.deleteAcademicYear(id);
        return ResponseEntity.noContent().build();
    }
}
