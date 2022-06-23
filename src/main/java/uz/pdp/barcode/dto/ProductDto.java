package uz.pdp.barcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private UUID id;

    @NotBlank
    private String name;
    @NotBlank
    private String barcode;
    @NotNull
    private UUID   categoryId;
    @NotNull
    private UUID   weightTypeId;
    @NotNull
    private UUID   brandId;
    @NotNull
    private double weight;
}
