package com.coreapi.controller;

import com.coreapi.client.*;
import com.coreapi.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class CoreController {

    private final ScrapingClient scrapingClient;

    // 📌 Tester le bon fonctionnement de l'API
    @GetMapping("/test")
    public String testEndpoint() {
        return "API is running!";
    }

}
