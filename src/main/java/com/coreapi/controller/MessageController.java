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

    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageCreationDTO messageCreationDTO) {
        return ResponseEntity.ok(messageClient.createMessage(messageCreationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok(messageClient.getMessageById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateMessage(@PathVariable String id, @RequestBody MessageUpdateDTO messageUpdateDTO) {
        return ResponseEntity.ok(messageClient.updateMessage(id, messageUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        messageClient.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/etudiants/{id}")
    public ResponseEntity<List<MessageDTO>> getMessagesByEtudiant(@PathVariable Long id, @RequestParam(required = false) Boolean lu) {
        return ResponseEntity.ok(messageClient.getMessagesByEtudiant(id, lu));
    }
}
