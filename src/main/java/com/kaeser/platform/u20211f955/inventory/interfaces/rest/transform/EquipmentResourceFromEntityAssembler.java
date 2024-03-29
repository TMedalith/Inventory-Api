package com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment entity) {
        return new EquipmentResource(entity.getId(), entity.getMaterialSerialNumber(), entity.getModel(), entity.getEquipmentType().toString());
    }
}
