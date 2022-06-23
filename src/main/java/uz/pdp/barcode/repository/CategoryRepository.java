package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.barcode.model.Category;
import uz.pdp.barcode.projection.NameProjection;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Query(nativeQuery = true,
    value = "select cast(id as varchar),\n" +
            "       name\n" +
            "from category")
    List<NameProjection> getAllCategory();
}
