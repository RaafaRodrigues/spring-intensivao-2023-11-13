package com.curso.spring.boot.controller;

import com.curso.spring.boot.dto.GameListDTO;
import com.curso.spring.boot.dto.GameMinDTO;
import com.curso.spring.boot.dto.GameReplacementDTO;
import com.curso.spring.boot.services.GameListService;
import com.curso.spring.boot.services.GameService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/{listId}/replacement")
    public ResponseEntity<List<GameMinDTO>> findByListId(@PathVariable("listId") Long listId,
                                                         @RequestBody GameReplacementDTO gameReplacementDTO) {
        gameListService.move(listId, gameReplacementDTO.getSourceIndex(), gameReplacementDTO.getDestinationIndex());
        return ResponseEntity.ok().build();
    }
}
