package com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources;

public record SparePartResource(Long id, String materialSerialNumber, int supplierId, String model, String supplierProvidedSerialNumber, Long equipmentId) {
}
