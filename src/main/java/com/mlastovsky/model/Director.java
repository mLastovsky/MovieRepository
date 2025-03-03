package com.mlastovsky.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Movie> movies;

}
