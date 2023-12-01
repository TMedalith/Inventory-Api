package com.kaeser.platform.u20211f955.inventory.domain.model.commands;

public record AddSparePartCommand(int supplierId, String model, String supplierProvidedSerialNumber, Long equipmentId) {

}
