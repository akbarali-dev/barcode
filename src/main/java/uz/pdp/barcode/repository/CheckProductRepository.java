package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.barcode.model.Check;
import uz.pdp.barcode.model.CheckProduct;

import java.util.UUID;

public interface CheckProductRepository extends JpaRepository<CheckProduct, UUID> {
}
