package com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.SparePart;
import org.hibernate.metamodel.mapping.ordering.ast.SequencePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SparePartRepository  extends JpaRepository<SparePart, Long> {
     Optional<SparePart> findByEquipmentId(Long equipmentId);
    Optional<SparePart> findByMaterialSerialNumber(String materialSerialNumber);
    Optional<SparePart> findBySupplierId(int supplierId);
    Optional<SparePart> findByModel(String model);
    Optional<SparePart> findBySupplierProvidedSerialNumber(String supplierProvidedSerialNumber);
}
