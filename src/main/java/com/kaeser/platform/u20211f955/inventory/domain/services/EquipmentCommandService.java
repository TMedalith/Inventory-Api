package com.kaeser.platform.u20211f955.inventory.domain.services;

import com.kaeser.platform.u20211f955.inventory.domain.model.commands.CreateEquipmentCommand;


public interface EquipmentCommandService {
    Long Handle(CreateEquipmentCommand command);
}
