package com.kaeser.platform.u20211f955.inventory.domain.model.aggregates;

import com.kaeser.platform.u20211f955.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String materialSerialNumber;

    private int supplierId;

    private String model;

    private String supplierProvidedSerialNumber;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime created_at;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "equipment_id", nullable = false)
    private Equipment equipment;

    public SparePart(int supplierId, String model, String supplierProvidedSerialNumber) {
        this.supplierId = supplierId;
        this.model = model;
        this.supplierProvidedSerialNumber = supplierProvidedSerialNumber;
        this.materialSerialNumber = generateMaterialSerialNumber();
        created_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();
    }

    public void updateEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public SparePart() {

    }

    private String generateMaterialSerialNumber() {
        return UUID.randomUUID().toString();
    }

}
