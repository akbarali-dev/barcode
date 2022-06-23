package uz.pdp.barcode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockDto {
    private UUID      id;
    @NotNull
    private UUID      productId;
    @NotNull
    private LocalDate expirationTime;
    @NotNull
    private LocalDate timeOfProduct;
    @NotNull
    private double    sellPrice;
    @NotNull
    private double    entryPrice;
    @NotNull
    private double    quantity;


}
