package com.curso.spring.boot.services;

import com.curso.spring.boot.projections.GameMinProjection;
import com.curso.spring.boot.repositories.GameRepository;
import com.curso.spring.boot.entities.GameList;
import com.curso.spring.boot.repositories.GameListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GameListService {

    private final GameListRepository repository;

    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameList> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> gameMinProjections =
                gameRepository.searchByList(listId);
        GameMinProjection moveSource = gameMinProjections.get(sourceIndex);
        GameMinProjection moveDestination = gameMinProjections.get(destinationIndex);

        repository.updateBelongingPosition(listId, moveSource.getId(), moveDestination.getPosition());
        repository.updateBelongingPosition(listId, moveDestination.getId(), moveSource.getPosition());
    }
}
