package uz.pdp.barcode.projection;

import java.util.UUID;

public interface StockProjection {
    UUID getId();

    String getProductName();

    double getEntryPrice();

    double getSellPrice();

    double getQuantity();
}
