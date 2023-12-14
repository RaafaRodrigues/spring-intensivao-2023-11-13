package com.curso.spring.boot.dto;

import com.curso.spring.boot.entities.GameList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(GameList gameList) {
        BeanUtils.copyProperties(gameList, this);
    }
}
