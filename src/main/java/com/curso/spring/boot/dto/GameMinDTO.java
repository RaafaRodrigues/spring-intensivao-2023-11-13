package com.curso.spring.boot.dto;

import com.curso.spring.boot.entities.Game;
import com.curso.spring.boot.projections.GameMinProjection;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }
    public GameMinDTO(GameMinProjection entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
