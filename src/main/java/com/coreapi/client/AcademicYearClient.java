package com.coreapi.client;

import com.coreapi.dto.AcademicYearDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "academic-year-api", url = "http://localhost:8080/academic-year")
public interface AcademicYearClient {

    @GetMapping
    List<AcademicYearDTO> getAllAcademicYears();

    @GetMapping("/{id}")
    AcademicYearDTO getAcademicYearById(@PathVariable Long id);

    @PostMapping
    AcademicYearDTO createAcademicYear(@RequestBody AcademicYearDTO academicYearDTO);

    @PutMapping("/{id}")
    AcademicYearDTO updateAcademicYear(@PathVariable Long id, @RequestBody AcademicYearDTO academicYearDTO);

    @DeleteMapping("/{id}")
    void deleteAcademicYear(@PathVariable Long id);
}
