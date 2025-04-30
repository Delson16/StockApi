package com.comerce.stockApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProdutoRegistroDto(
        @NotBlank String nome, 
        @Positive float preco) {
}


