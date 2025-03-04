package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupeDTO {
    private Long id;
    private String nom;
    private int capaciteMax;
    private List<Long> etudiantsIds;  // Liste des étudiants assignés à ce groupe
}
