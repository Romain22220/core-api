package com.coreapi.client;

import com.coreapi.dto.StudentDTO;

import java.util.List;

/**
 * Fallback class for StudentClient
 * Cette classe est utilisée pour gérer les erreurs de communication avec le service Student
 */
public class StudentFallback implements StudentClient{
    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of();
    }

    @Override
    public StudentDTO getStudent(String id) {
       return new StudentDTO(0,"N/A","N/A",null,0,"N/A");
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return new StudentDTO(0,"N/A","N/A",null,0,"N/A");
    }

    @Override
    public StudentDTO updateStudent(String id, StudentDTO studentDTO) {
        return new StudentDTO(0,"N/A","N/A",null,0,"N/A");
    }


    @Override
    public void deleteStudent(String id) {
        System.out.println("Student with id "+id+" not found");
    }

}
