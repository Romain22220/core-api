package com.coreapi.client;

import com.coreapi.dto.MessageCreationDTO;
import com.coreapi.dto.MessageDTO;
import com.coreapi.dto.MessageUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
* Interface pour la communication avec le service Message
 */
@FeignClient(name = "message-api", url = "http://localhost:8080/api/messages")
public interface MessageClient {

    @PostMapping
    MessageDTO createMessage(@RequestBody MessageCreationDTO messageCreationDTO);

    @GetMapping("/{id}")
    MessageDTO getMessageById(@PathVariable String id);

    @PutMapping("/{id}")
    MessageDTO updateMessage(@PathVariable String id, @RequestBody MessageUpdateDTO messageUpdateDTO);

    @DeleteMapping("/{id}")
    void deleteMessage(@PathVariable String id);

    @GetMapping("/etudiants/{id}")
    List<MessageDTO> getMessagesByEtudiant(@PathVariable Long id, @RequestParam(required = false) Boolean lu);
}