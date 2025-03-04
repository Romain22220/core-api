package com.coreapi.client;


import com.coreapi.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "apiStudent", url = "http://localhost:8080", fallback = StudentFallback.class)
public interface StudentClient {

    @GetMapping("/students")  // Ajoute ce endpoint
    List<StudentDTO> getAllStudents();

    @GetMapping("/student/{id}")
    StudentDTO getStudent(@PathVariable("id") String id);

    @PostMapping("/student")
    StudentDTO createStudent(StudentDTO studentDTO);

    @PutMapping("/student/{id}")
    StudentDTO updateStudent(@PathVariable("id") String id, StudentDTO studentDTO);

    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable("id") String id);

}
