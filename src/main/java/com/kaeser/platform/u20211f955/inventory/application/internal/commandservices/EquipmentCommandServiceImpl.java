package com.kaeser.platform.u20211f955.inventory.application.internal.commandservices;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u20211f955.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u20211f955.inventory.domain.model.valueobjects.EEquipmentType;
import com.kaeser.platform.u20211f955.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u20211f955.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Long Handle(CreateEquipmentCommand command) {
        validateEquipmentType(command.equipmentType());
        var equipment = new Equipment(command.model(), EEquipmentType.valueOf(command.equipmentType()));
        equipmentRepository.save(equipment);
        return equipment.getId();
    }

    private void validateEquipmentType(String equipmentType) {
        if (!"ScrewCompressor".equals(equipmentType) && !"AirTreatment".equals(equipmentType)) {
            throw new IllegalArgumentException("Invalid equipmentType. Allowed values are: ScrewCompressor, AirTreatment");
        }
    }


}