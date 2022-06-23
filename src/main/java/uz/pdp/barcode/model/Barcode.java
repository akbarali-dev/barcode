package uz.pdp.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IndexColumn;
import org.springframework.stereotype.Indexed;
import uz.pdp.barcode.model.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Barcode extends AbsEntity {
    @Column(nullable = false, unique = true)

    private String barcode;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
