package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrapedFormationDTO {
    private String name;
    private int tpSize;
    private int tdSize;
    private int optionalUE;
    private List<UeDTO> ues;
}
