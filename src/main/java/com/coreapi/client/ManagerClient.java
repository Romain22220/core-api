package com.coreapi.client;

import com.coreapi.dto.ManagerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "manager-api", url = "http://localhost:8100")
public interface ManagerClient {

    @GetMapping("/managers")
    List<ManagerDTO> getAllManagers();

    @GetMapping("/managers/{id}")
    ManagerDTO getManagerById(@PathVariable Long id);

    @PutMapping("/managers/{id}")
    ManagerDTO updateManager(@PathVariable Long id, @RequestBody ManagerDTO managerDTO);

    @DeleteMapping("/managers/{id}")
    void deleteManager(@PathVariable Long id);
}
