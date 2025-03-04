package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChoixUEOptionsDTO {
    private Long etudiantId;
    private List<Long> ueOptionnelles;
}