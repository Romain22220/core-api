package com.coreapi.controller;

import com.coreapi.client.AuthentificationClient;
import com.coreapi.dto.AuthRequestDTO;
import com.coreapi.dto.RegisterRequestDTO;
import com.coreapi.dto.TokenResponseDTO;
import com.coreapi.dto.MeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthentificationClient authentificationClient;

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authentificationClient.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody AuthRequestDTO request) {
        return ResponseEntity.ok(authentificationClient.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<MeResponseDTO> validateToken(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(authentificationClient.validateToken(token));
    }

    @DeleteMapping("/unregister")
    public ResponseEntity<Void> unregister(@RequestParam String username, @RequestParam String password) {
        authentificationClient.unregister(username, password);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        authentificationClient.logout(token);
        return ResponseEntity.noContent().build();
    }
}
