package com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u20211f955.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u20211f955.inventory.domain.model.valueobjects.EEquipmentType;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.EquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource) {
        return new CreateEquipmentCommand(resource.model(), resource.equipmentType());
    }
}
