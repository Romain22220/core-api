package com.coreapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthentificationDTO {
    private String username;
    private String password;
    private int student;
    private String message;
    private String token;
    private Boolean ok;
    private int studentNumber;
}
