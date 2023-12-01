package com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.SparePart;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.SparePartResource;

public class
SparePartResourceFromEntityAssembler {
    public static SparePartResource toResourceFromEntity(SparePart entity) {
        return new SparePartResource(entity.getId(), entity.getMaterialSerialNumber(), entity.getSupplierId(), entity.getModel(), entity.getSupplierProvidedSerialNumber(), entity.getEquipment().getId());
    }
}
