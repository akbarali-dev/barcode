package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.barcode.model.Brand;
import uz.pdp.barcode.projection.NameProjection;

import java.util.List;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Query(nativeQuery = true,
            value = "select cast(id as varchar),\n" +
                    "       name\n" +
                    "from brand")
    List<NameProjection> getAllBrand();
}
