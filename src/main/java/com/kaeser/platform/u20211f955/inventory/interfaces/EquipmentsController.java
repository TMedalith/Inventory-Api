package com.kaeser.platform.u20211f955.inventory.interfaces;

import com.kaeser.platform.u20211f955.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.u20211f955.inventory.domain.model.queries.GetEquipmentByIdQuery;
import com.kaeser.platform.u20211f955.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u20211f955.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.u20211f955.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/equipments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Equipment Management Endpoints")
public class EquipmentsController {

    private final EquipmentCommandService equipmentCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentsController(EquipmentCommandService equipmentCommandService, EquipmentQueryService equipmentQueryService) {
        this.equipmentCommandService = equipmentCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }

    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource createEquipmentResource) {
            var createEquipmentCommand = new CreateEquipmentCommand(createEquipmentResource.model(), createEquipmentResource.equipmentType());
            var equipmentId = equipmentCommandService.Handle(createEquipmentCommand);
            if (equipmentId == 0L) {
                return ResponseEntity.badRequest().build();
            }
            var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
            var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
            if (equipment.isEmpty()) return ResponseEntity.badRequest().build();
            var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
            return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);

    }


    @GetMapping("/{equipmentId}")
    public ResponseEntity<EquipmentResource> getEquipmentById(@PathVariable Long equipmentId) {
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
        if (equipment.isEmpty()) return ResponseEntity.badRequest().build();
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return ResponseEntity.ok(equipmentResource);
    }
}
