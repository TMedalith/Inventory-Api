package com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentRepository  extends JpaRepository<Equipment, Long> {
    Optional<Equipment> findByMaterialSerialNumber(String materialSerialNumber);

}
