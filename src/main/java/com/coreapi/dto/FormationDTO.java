package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationDTO {

    private Long id;
    private String nom;
    private int tailleTD;
    private int tailleTP;
    private int nbUeOptionnelles;

}
