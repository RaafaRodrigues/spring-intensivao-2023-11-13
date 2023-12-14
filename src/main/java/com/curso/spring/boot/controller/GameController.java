package com.curso.spring.boot.controller;

import com.curso.spring.boot.dto.GameDTO;
import com.curso.spring.boot.dto.GameListDTO;
import com.curso.spring.boot.dto.GameMinDTO;
import com.curso.spring.boot.services.GameListService;
import com.curso.spring.boot.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new GameDTO(gameService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {
        return ResponseEntity.ok(gameService.findAll()
                .stream().map(GameMinDTO::new)
                .toList());
    }
}
