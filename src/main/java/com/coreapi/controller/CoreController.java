package com.coreapi.controller;

import com.coreapi.client.StudentClient;
import com.coreapi.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class CoreController {
    private final StudentClient studentClient;

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String id) {
        StudentDTO student = studentClient.getStudent(id);
        return ResponseEntity.ok(student);
    }
}
