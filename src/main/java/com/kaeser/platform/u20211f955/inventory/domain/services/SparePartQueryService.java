package com.kaeser.platform.u20211f955.inventory.domain.services;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.SparePart;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.*;

import java.util.Optional;

public interface SparePartQueryService {
    Optional<SparePart> handle(GetSparePartByIdQuery query);
    Optional<SparePart> handle(GetSparePartByMaterialSerialNumberQuery query);
    Optional<SparePart> handle(GetSparePartsByEquipmentIdQuery query);

}
