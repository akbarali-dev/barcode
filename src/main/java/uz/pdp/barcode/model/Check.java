package uz.pdp.barcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.barcode.model.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "checks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Check extends AbsEntity {
    String name;
}
