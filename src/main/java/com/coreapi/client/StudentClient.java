package com.coreapi.client;


import com.coreapi.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interface pour la communication avec le service Student
 */

@FeignClient(name = "apiStudent", url = "http://localhost:8300", fallback = StudentFallback.class)
public interface StudentClient {

    @GetMapping("/students")  // Ajoute ce endpoint
    List<StudentDTO> getAllStudents();

    @GetMapping("/students/{id}")
    StudentDTO getStudent(@PathVariable("id") String id);

    @PostMapping("/students")
    StudentDTO createStudent(StudentDTO studentDTO);

    @PutMapping(path = "/students/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    StudentDTO updateStudent(@PathVariable("id") String id, @RequestBody StudentDTO studentDTO);


    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable("id") String id);

}
