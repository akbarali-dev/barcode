package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.barcode.model.Check;

import java.util.UUID;

public interface CheckRepository extends JpaRepository<Check, UUID> {
}
