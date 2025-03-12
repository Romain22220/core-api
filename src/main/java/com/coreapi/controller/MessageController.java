package com.coreapi.controller;

import com.coreapi.client.MessageClient;
import com.coreapi.dto.MessageDTO;
import com.coreapi.dto.MessageCreationDTO;
import com.coreapi.dto.MessageUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageClient messageClient;

    // 📌 Récupérer tous les messages
    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageCreationDTO messageCreationDTO) {
        return ResponseEntity.ok(messageClient.createMessage(messageCreationDTO));
    }

    // 📌 Récupérer un message
    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok(messageClient.getMessageById(id));
    }

    // 📌 Mettre à jour un message
    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateMessage(@PathVariable String id, @RequestBody MessageUpdateDTO messageUpdateDTO) {
        return ResponseEntity.ok(messageClient.updateMessage(id, messageUpdateDTO));
    }

    // 📌 Supprimer un message
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        messageClient.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

    // 📌 Récupérer tous les messages d'un étudiant
    @GetMapping("/etudiants/{id}")
    public ResponseEntity<List<MessageDTO>> getMessagesByEtudiant(@PathVariable Long id, @RequestParam(required = false) Boolean lu) {
        return ResponseEntity.ok(messageClient.getMessagesByEtudiant(id, lu));
    }
}
