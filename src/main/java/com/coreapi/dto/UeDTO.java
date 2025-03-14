package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UeDTO {
    private String name;
    private int capacity;
    private boolean isMandatory;
}
