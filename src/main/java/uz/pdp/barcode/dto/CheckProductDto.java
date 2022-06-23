package uz.pdp.barcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckProductDto {
    private UUID   product;
    private String comment;
    private double quantity;
    private double price;
}
