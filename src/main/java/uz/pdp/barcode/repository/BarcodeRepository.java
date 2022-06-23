package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.barcode.model.Barcode;
import uz.pdp.barcode.model.Brand;
import uz.pdp.barcode.projection.NameProjection;

import java.util.List;
import java.util.UUID;

public interface BarcodeRepository extends JpaRepository<Barcode, UUID> {

}
