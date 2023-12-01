package com.kaeser.platform.u20211f955.inventory.domain.services;

import com.kaeser.platform.u20211f955.inventory.domain.model.commands.AddSparePartCommand;
import com.kaeser.platform.u20211f955.inventory.domain.model.commands.CreateEquipmentCommand;

public interface SparePartCommandService {
    Long Handle(AddSparePartCommand command);
}
