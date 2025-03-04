package com.coreapi.client;

import com.coreapi.dto.StudentDTO;

import java.util.List;

public class StudentFallback implements StudentClient{
    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of();
    }

    @Override
    public StudentDTO getStudent(String id) {
       return new StudentDTO(0,"N/A","N/A",null,0,"N/A");
    }
}
