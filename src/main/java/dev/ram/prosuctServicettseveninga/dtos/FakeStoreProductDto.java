package dev.ram.prosuctServicettseveninga.dtos;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    @Nullable
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    @Nullable
    private RatingDto rating;
}
