package com.coreapi.client;


import com.coreapi.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "apiStudent", url = "http://localhost:8080", fallback = StudentFallback.class)
public interface StudentClient {

    @GetMapping("/students")  // Ajoute ce endpoint
    List<StudentDTO> getAllStudents();

    @GetMapping("/student/{id}")
    StudentDTO getStudent(@PathVariable("id") String id);
}
