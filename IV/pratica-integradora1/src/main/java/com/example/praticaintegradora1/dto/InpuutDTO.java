package com.example.praticaintegradora1.dto;

import lombok.Data;

import java.util.List;

@Data
public class InpuutDTO {
    private String title;
    private List<AuthorInputDTO> authorList;
}
