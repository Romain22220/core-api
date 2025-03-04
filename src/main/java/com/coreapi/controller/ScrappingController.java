package com.coreapi.controller;

import com.coreapi.client.ScrapingClient;
import com.coreapi.dto.ScrapedFormationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scraping")
@RequiredArgsConstructor
public class ScrappingController {

    private final ScrapingClient scrapingClient;

    // 📌 Scraper les formations pour une année donnée
    @GetMapping
    public ResponseEntity<List<ScrapedFormationDTO>> scrapeFormations(@RequestParam("year") String year) {
        return ResponseEntity.ok(scrapingClient.scrapeFormations(year));
    }
}
