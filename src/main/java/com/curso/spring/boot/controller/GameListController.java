package com.curso.spring.boot.controller;

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
@RequiredArgsConstructor
@RequestMapping(value = "/lists")
public class GameListController {
    private final GameListService gameListService;
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAllGameList() {
        return ResponseEntity.ok(gameListService.findAll()
                .stream().map(GameListDTO::new)
                .toList());
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByListId(@PathVariable("listId") Long listId) {
        return ResponseEntity.ok(gameService.findByListId(listId)
                .stream().map(GameMinDTO::new)
                .toList());
    }
}
