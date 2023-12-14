package com.curso.spring.boot.services;

import com.curso.spring.boot.dto.GameMinDTO;
import com.curso.spring.boot.entities.Game;
import com.curso.spring.boot.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
