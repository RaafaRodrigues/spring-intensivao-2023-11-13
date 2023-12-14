package com.curso.spring.boot.dto;

import com.curso.spring.boot.entities.Game;
import lombok.*;

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
       this.id = entity.getId();
       this.title = entity.getTitle();
       this.year = entity.getYear();
       this.imgUrl = entity.getImgUrl();
       this.shortDescription = entity.getShortDescription();
    }
}
