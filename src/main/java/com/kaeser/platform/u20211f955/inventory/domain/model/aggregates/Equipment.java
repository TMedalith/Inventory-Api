package com.kaeser.platform.u20211f955.inventory.domain.model.aggregates;

import com.kaeser.platform.u20211f955.inventory.domain.model.valueobjects.EEquipmentType;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Equipment extends AbstractAggregateRoot<Equipment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materialSerialNumber;

    private String model;


    @Enumerated(EnumType.STRING)
    private EEquipmentType equipmentType;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private Date updatedAt;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<SparePart> spareParts;

    public Equipment(String model, EEquipmentType equipmentType) {
        this.model = model;
        this.equipmentType = equipmentType;
        this.materialSerialNumber = GenerateMaterialSerialNumber().toString();
        updatedAt = new Date();
        createdAt = new Date();
    }

    public Equipment() {

    }

    public static UUID GenerateMaterialSerialNumber()
    {
        return UUID.randomUUID();
    }

}
