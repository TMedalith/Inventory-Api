package com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.SparePart;
import com.kaeser.platform.u20211f955.inventory.domain.model.commands.AddSparePartCommand;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.CreateSparePartResource;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.SparePartResource;

public class CreateSparePartCommandFromResourceAssembler {
    public static AddSparePartCommand toCommandFromResource(CreateSparePartResource resource) {
        return new AddSparePartCommand(resource.supplierId(), resource.model(), resource.supplierProvidedSerialNumber(), null);
    }
}
