package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private int numeroCandidat;
    private String mail;


}
