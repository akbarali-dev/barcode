package uz.pdp.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.barcode.model.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand extends AbsEntity {
    @Column(nullable = false, unique = true)
    private String name;
}
