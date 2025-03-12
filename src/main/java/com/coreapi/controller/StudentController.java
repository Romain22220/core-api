package com.coreapi.controller;

import com.coreapi.client.StudentClient;
import com.coreapi.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentClient studentClient;

    // 📌 Récupérer tous les étudiants
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentClient.getAllStudents());
    }

    // 📌 Récupérer un étudiant par son id
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String id) {
        return ResponseEntity.ok(studentClient.getStudent(id));
    }

    // 📌 Créer un étudiant
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentClient.createStudent(studentDTO));
    }

    // 📌 Mettre à jour un étudiant
    @PutMapping(path = "/students/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentClient.updateStudent(id, studentDTO));
    }

    // 📌 Supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentClient.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
