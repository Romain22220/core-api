package com.coreapi.client;

import com.coreapi.dto.AuthRequestDTO;
import com.coreapi.dto.MeResponseDTO;
import com.coreapi.dto.RegisterRequestDTO;
import com.coreapi.dto.TokenResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "auth-api", url = "http://localhost:8080/api/auth")
public interface AuthentificationClient {
        @PostMapping("/register")
        TokenResponseDTO register(@RequestBody RegisterRequestDTO request);

        @PostMapping("/login")
        TokenResponseDTO login(@RequestBody AuthRequestDTO request);

        @GetMapping("/me")
        MeResponseDTO validateToken(@RequestHeader("Authorization") String token);

        @DeleteMapping("/unregister")
        void unregister(@RequestParam("username") String username, @RequestParam("password") String password);

        @DeleteMapping("/logout")
        void logout(@RequestHeader("Authorization") String token);
}

