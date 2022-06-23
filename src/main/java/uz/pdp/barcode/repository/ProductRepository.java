package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.barcode.model.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
