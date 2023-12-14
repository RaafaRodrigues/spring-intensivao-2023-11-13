package com.curso.spring.boot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_game")
@EqualsAndHashCode(of = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "game_year")
    private Integer year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "platforms")
    private String platforms;

    @Column(name = "score")
    private Double score;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "short_description",
            length = 500)
    private String shortDescription;

    @Column(name = "long_description",
            length = 500)
    private String longDescription;
}
