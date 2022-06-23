package uz.pdp.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.barcode.model.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock extends AbsEntity {
    // TODO: 6/23/2022
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private LocalDate timeOfProduct;

    @Column(nullable = false)
    private LocalDate expirationTime;

    @Column(nullable = false)
    private double entryPrice;

    @Column(nullable = false)
    private double sellPrice;

    @Column(nullable = false)
    private double quantity;
}
