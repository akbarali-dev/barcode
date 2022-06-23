package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.barcode.model.Stock;
import uz.pdp.barcode.projection.StockProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {

@Query(nativeQuery = true,
value = "select cast(s.id as varchar),\n" +
        "       p.name as productName,\n" +
        "       s.entry_price as entryPrice,\n" +
        "       s.sell_price as sellPrice,\n" +
        "       s.quantity\n" +
        "from stock s\n" +
        "         join product p on p.id = s.product_id")
    List<StockProjection> getAllStock();

    Optional<Stock> findByProductId(UUID productId);
}
