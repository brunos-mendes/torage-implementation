package com.example.praticaintegradora1.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Author {
    private int id;
    private String name;
}
