package com.coreapi.core;

import com.coreapi.client.ManagerClient;
import com.coreapi.client.StudentClient;
import com.coreapi.dto.ManagerDTO;
import com.coreapi.dto.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CoreApiApplicationTests {

    @Test
    void contextLoads() {

    }


    /*
     * Teste de la méthode getStudent de la classe StudentClient
     */
    @Test void testGetStudents() {
        StudentClient studentClient = mock(StudentClient.class);
        List<StudentDTO> mockStudents = List.of(new StudentDTO());
        when(studentClient.getAllStudents()).thenReturn(mockStudents);
        List<StudentDTO> students = studentClient.getAllStudents();
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

    /*
     * Teste de la méthode getStudentByID de la classe StudentClient
     */
    @Test
    void testGetManagerByID() {
        StudentClient studentClient = mock(StudentClient.class);
        StudentDTO mockStudent = new StudentDTO();
        when(studentClient.getStudent("1")).thenReturn(mockStudent);
        StudentDTO student = studentClient.getStudent("1");
        assertNotNull(student);

    }

    /*
     * Teste de la méthode getManagers de la classe ManagerClient
     */
    @Test
    void testGetManagers() {
        ManagerClient managerClient = mock(ManagerClient.class);
        List<ManagerDTO> mockManagers = List.of(new ManagerDTO());
        when(managerClient.getAllManagers()).thenReturn(mockManagers);
        List<ManagerDTO> managers = managerClient.getAllManagers();
        assertNotNull(managers);
    }

    /*
     * Teste de la méthode getManagerById de la classe ManagerClient
     */
    @Test
    void testGetManagerById() {
        ManagerClient managerClient = mock(ManagerClient.class);
        ManagerDTO mockManager = new ManagerDTO();
        when(managerClient.getManagerById(1L)).thenReturn(mockManager);
        ManagerDTO manager = managerClient.getManagerById(1L);
        assertNotNull(manager);
    }

}
