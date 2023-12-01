package com.kaeser.platform.u20211f955.inventory.domain.services;

import com.kaeser.platform.u20211f955.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.u20211f955.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetAllEquipmentsQuery;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetEquipmentByMaterialSerialNumber;

import java.util.List;
import java.util.Optional;

public interface EquipmentQueryService {
  Optional <Equipment> handle(GetEquipmentByIdQuery query);
  Optional <Equipment> handle(GetEquipmentByMaterialSerialNumber query);
  List <Equipment> handle(GetAllEquipmentsQuery query);

}
