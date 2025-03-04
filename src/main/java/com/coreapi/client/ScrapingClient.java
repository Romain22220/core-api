package com.coreapi.client;

import com.coreapi.dto.ScrapedFormationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "scraping-api", url = "http://localhost:8080/api/scrapper")
public interface ScrapingClient {

    @GetMapping
    List<ScrapedFormationDTO> scrapeFormations(@RequestParam("year") String year);
}