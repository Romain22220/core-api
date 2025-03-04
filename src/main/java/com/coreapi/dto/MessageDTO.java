package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String id;
    private String texte;
    private boolean lu;
    private LocalDateTime dateCreation;
    private String sujet;
    private Long etudiantId;
}
