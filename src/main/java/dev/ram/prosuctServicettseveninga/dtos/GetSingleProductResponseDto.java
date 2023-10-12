package dev.ram.prosuctServicettseveninga.dtos;

import dev.ram.prosuctServicettseveninga.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {
    private Product product;
}
