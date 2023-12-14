package com.curso.spring.boot.repositories;

import com.curso.spring.boot.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByOrderByTitleAsc();
}
