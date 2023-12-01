package com.kaeser.platform.u20211f955.inventory.application.internal.queryservices;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetAllEquipmentsQuery;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetEquipmentByMaterialSerialNumber;
import com.kaeser.platform.u20211f955.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EquipmentQueryServiceImpl implements EquipmentQueryService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }



    @Override
    public Optional<Equipment> handle(GetEquipmentByIdQuery query) {

        return equipmentRepository.findById(query.id());
    }

    @Override
    public Optional<Equipment> handle(GetEquipmentByMaterialSerialNumber query) {
        return equipmentRepository.findByMaterialSerialNumber(query.materialSerialNumber());
    }

    @Override
    public List<Equipment> handle(GetAllEquipmentsQuery query) {
        return equipmentRepository.findAll();
    }
}
