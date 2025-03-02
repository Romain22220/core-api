package com.coreapi.client;


import com.coreapi.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-api", url = "http://localhost:8080", fallback = StudentFallback.class)
public interface StudentClient {
    @GetMapping("/student/{id}")
    StudentDTO getStudent(@PathVariable("id") String id);
}
