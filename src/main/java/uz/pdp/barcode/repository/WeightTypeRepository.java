package uz.pdp.barcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.barcode.model.WeightType;
import uz.pdp.barcode.model.template.AbsEntity;
import uz.pdp.barcode.projection.NameProjection;

import java.util.List;
import java.util.UUID;

public interface WeightTypeRepository extends JpaRepository<WeightType, UUID> {
    @Query(nativeQuery = true,
            value = "select cast(id as varchar),\n" +
                    "       name\n" +
                    "from weight_type")
    List<NameProjection> getAllWeightType();
}
