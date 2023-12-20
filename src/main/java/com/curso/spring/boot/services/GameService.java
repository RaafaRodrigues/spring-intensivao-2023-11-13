package com.curso.spring.boot.services;

import com.curso.spring.boot.entities.Game;
import com.curso.spring.boot.projections.GameMinProjection;
import com.curso.spring.boot.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Transactional(readOnly = true)
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly = true)
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Game> findAllAndOrderByTitle() {
        return gameRepository.findAllByOrderByTitleAsc();
    }

    @Transactional(readOnly = true)
    public List<GameMinProjection> findByListId(Long listId) {
        return gameRepository.searchByList(listId);
    }

}
