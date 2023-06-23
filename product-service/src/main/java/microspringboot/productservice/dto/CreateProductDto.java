package microspringboot.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class CreateProductDto {
    @NotBlank
    private String name;
    @Positive
    private double price;
    @NotBlank
    private String color;
    @NotBlank
    private String category;
}
