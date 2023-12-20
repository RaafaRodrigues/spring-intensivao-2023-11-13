package com.curso.spring.boot.services;


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

    @Transactional(readOnly = true)
    public List<GameList> findAll() {
        return repository.findAll();
    }
}
