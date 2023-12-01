package com.kaeser.platform.u20211f955.inventory.domain.model.commands;

import com.kaeser.platform.u20211f955.inventory.domain.model.valueobjects.EEquipmentType;

public record CreateEquipmentCommand(String model, String equipmentType) {

}